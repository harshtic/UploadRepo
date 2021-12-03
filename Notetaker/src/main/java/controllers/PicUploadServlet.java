package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.util.SystemOutLogger;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;


public class PicUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		System.out.println("success");
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println(id);
		User user = (User)session.getAttribute("user");
		System.out.println(user);
		String fileName = null;
		
		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				System.out.print("success~~~~~~~~");
				DiskFileItemFactory dfif = new DiskFileItemFactory();
				
				ServletFileUpload sfu = new ServletFileUpload(dfif);

				List<FileItem> fileItems = null;
				
				try{
					fileItems = sfu.parseRequest(request);	
				}catch(FileUploadException e){
					e.printStackTrace();
				}	
				
				FileItem fileItem = fileItems.get(0);
				fileName = fileItem.getName();
				System.out.print(fileName);
				
				ServletContext context = getServletContext();
				String uploadPath = "G:\\java projects\\Projects\\Notetaker\\src\\main\\webapp\\static\\images";

				File file = new File(uploadPath,fileName);	
				
				try{
					fileItem.write(file);
				}catch(Exception e){
					e.printStackTrace();	
				}
				System.out.print(fileName);
				
				user.setPic(fileName);
				user.setId(id);
				user.profPic();
				
				
				response.sendRedirect("Home.jsp");
			}
		}else{
			response.sendRedirect("sigin.jsp");
		}
	}
}
