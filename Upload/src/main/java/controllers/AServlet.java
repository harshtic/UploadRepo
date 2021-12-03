package controllers;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import org.apache.commons.fileupload.FileItem;

public class AServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		if(ServletFileUpload.isMultipartContent(request))
		{
			DiskFileItemFactory diff = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(diff);
			List<FileItem> fileItems = null;
			try{
				fileItems=sfu.parseRequest(request);
			}catch(FileUploadException e){
				e.printStackTrace();
			}
			
			String folderpath = "G:\\java projects\\Projects\\Upload\\src\\main\\webapp\\uploads";
			System.out.println(folderpath);
			  for(FileItem fileItem : fileItems){
				String fileName = fileItem.getName();
				File file = new File(folderpath,fileName);
				try{
					fileItem.write(file);

				}catch(Exception e){
					e.printStackTrace();
				}
			  }
		}
		System.out.println("success");
		request.getRequestDispatcher("index.html").forward(request,response);
	}
}