package com.digit.CrsWebApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentRequest {
	String sname;
	int age;
	String email;
	int cid;
	String course;
	String user_name;
	String description;
	private Connection con;
	private Statement stmt;
	private ResultSet resultset;
	private PreparedStatement pstmt;
	
	public StudentRequest() {
		String url = "jdbc:mysql://localhost:3306/crs1";
        String user = "root";
        String pwd = "yash8209@";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	
	public StudentRequest(String sname, int age, String email, int cid, String course, String user_name, String description) {
		super();
		this.sname = sname;
		this.age = age;
		this.email = email;
		this.cid = cid;
		this.course = course;
		this.user_name = user_name;
		this.description = description;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean addNewStud(String sname, int age, String email, int cid, String course, String uname, String desc) {
		try {
			
			pstmt = con.prepareStatement("insert into studentrequest(sname, age, email, cid, course, user_name, description)  values(?,?,?,?,?,?,?)");
			pstmt.setString(1, sname);
			pstmt.setInt(2, age);
			pstmt.setString(3, email);
			pstmt.setInt(4, cid);
			pstmt.setString(5, course);
			pstmt.setString(6, uname);
			pstmt.setString(7,desc);
			
			int x = pstmt.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<StudentRequest> SRs() {
		ArrayList<StudentRequest> sr = new ArrayList<StudentRequest>();
		try {
			
			stmt = con.createStatement();
			resultset = stmt.executeQuery("select * from studentrequest");
			
			while(resultset.next()==true) {
				
				sname = resultset.getString(1);
				age = resultset.getInt(2);
				email = resultset.getString(3);
				cid = resultset.getInt(4);
				course = resultset.getString(5);
				user_name = resultset.getString(6);
				description = resultset.getString(7);
				StudentRequest cursr = new StudentRequest(sname,age,email,cid,course,user_name,description);
				sr.add(cursr);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return sr;
	}
}
