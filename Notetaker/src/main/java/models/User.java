package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String contact;
	private String pic;

	//###################### Constructor #############################
	
	
	
	public User(String name, String email, String password, String contact) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}

	public User(Integer id, String name, String email, String password, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}

	public User() {
		super();
	}
	
	//###################### Method #############################
	
	public void profPic() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker?user=root&password=1234");

			String query = "update user set pics=? where id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, pic);
			pst.setInt(2, id);
			
			pst.executeUpdate();
			System.out.print("success~~~~");
			

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void editProfile() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker?user=root&password=1234");

			String query = "update user set name=?,email=?,password=?,contact=? where id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, password);
			pst.setString(4, contact);
			pst.setInt(5, id);
			
			pst.executeUpdate();
			

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	
	public boolean login() {
		boolean temp = false;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker?user=root&password=1234");

			String query = "select name,email,password,contact,id,pics from user where email=? and password=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			pst.setString(2,password);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				this.name = rs.getString(1);
				this.email = rs.getString(2);
				this.password = rs.getString(3);
				this.contact = rs.getString(4);
				this.id = rs.getInt(5);
				this.pic=rs.getString(6);
				
				temp=true;
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return temp;
	}
	
	
	
	
	public boolean saveUser() {
		boolean temp = false;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker?user=root&password=1234");

			String query = "insert into user(name,email,password,contact) values(?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3,password);
			pst.setString(4,contact);
			
			pst.executeUpdate();
			temp=true;

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return temp;
	}
	
	
	
	
		
	//###################### Getter-Setter #############################
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	
	

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
	
	
	
}
