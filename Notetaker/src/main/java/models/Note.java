package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Note {
	
	private Integer note_id;
	private String title;
	private String description;
	private User user;
	
	//###################### Constructor #############################
	
	public Note(String title, String description, User user) {
		super();
		this.title = title;
		this.description = description;
		this.user = user;
	}
	
	
	
	public Note(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}



	public Note() {
		super();
	}

	
	//###################### Methods #############################
	
	
	public static void deleteNote(int note_id) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker?user=root&password=1234");
			
			String query = "delete from notes where note_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			
			
			pst.setInt(1,note_id);
			
			pst.executeUpdate();
			

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	
	public void editNote() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker?user=root&password=1234");
			
			String query = "update notes set title=?,description=? where note_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, title);
			pst.setString(2, description);
		
			pst.setInt(3,note_id);
			
			pst.executeUpdate();
			

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	
	public void showNote(Integer noteId) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker?user=root&password=1234");
			
			String query = "select title,description from notes where note_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, noteId);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				this.title=rs.getString(1);
				this.description=rs.getString(2);
			}
			

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public Note(Integer note_id, String title, String description) {
		super();
		this.note_id = note_id;
		this.title = title;
		this.description = description;
	}


	
	public Note(Integer note_id) {
		super();
		this.note_id = note_id;
	}



	public ArrayList<Note> getAllNotes(User user){
	
	ArrayList<Note> getAllNotes = new ArrayList<Note>();
	try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker?user=root&password=1234");
			
			String query = "select note_id,title,description from notes where id=?";

			PreparedStatement pst = con.prepareStatement(query);
			

			pst.setInt(1, user.getId());   

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				this.note_id = rs.getInt(1);
				this.title=rs.getString(2);
				this.description=rs.getString(3);
				Note note = new Note(note_id,title,description);
				
				getAllNotes.add(note);
			}
			

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	
	return getAllNotes;
	}
	
	
	


	public void addNote() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker?user=root&password=1234");
			
			String query = "insert into notes(title,description,id) values(?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, title);
			pst.setString(2, description);
			pst.setInt(3,user.getId() );
			
			pst.executeUpdate();
			

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	//###################### Getter-Setter #############################

	public Integer getNote_id() {
		return note_id;
	}

	public void setNote_id(Integer note_id) {
		this.note_id = note_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getuser() {
		return user;
	}

	public void setuser(User user) {
		this.user = user;
	}
	
	
	
	

}
