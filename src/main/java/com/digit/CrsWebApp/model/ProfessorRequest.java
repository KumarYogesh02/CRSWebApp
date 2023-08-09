package com.digit.CrsWebApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfessorRequest {
	String pname;
	int age;
	int exp;
	int cid;
	String course;
	String user_name;
	String description;
	private Connection con;
	private Statement stmt;
	private ResultSet resultset;
	private PreparedStatement pstmt;
	
	public ProfessorRequest() {
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

	public ProfessorRequest(String pname, int age, int exp, int cid, String course, String user_name, String description) {
		this.pname = pname;
		this.age = age;
		this.exp = exp;
		this.cid = cid;
		this.course = course;
		this.user_name = user_name;
		this.description = description;
	}



	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
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

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		description = description;
	}
	
	public boolean addNewProf(String pname, int age, int exp, int cid, String course, String uname, String desc) {
		try {
			
			pstmt = con.prepareStatement("insert into professorrequest(pname, age, exp, cid, course, user_name, description)  values(?,?,?,?,?,?,?)");
			pstmt.setString(1, pname);
			pstmt.setInt(2, age);
			pstmt.setInt(3, exp);
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
	
	public ArrayList<ProfessorRequest> PRs() {
		ArrayList<ProfessorRequest> pr = new ArrayList<ProfessorRequest>();
		try {
			
			stmt = con.createStatement();
			resultset = stmt.executeQuery("select * from professorrequest");
			
			while(resultset.next()==true) {
				
				pname = resultset.getString(1);
				age = resultset.getInt(2);
				exp = resultset.getInt(3);
				cid = resultset.getInt(4);
				course = resultset.getString(5);
				user_name = resultset.getString(6);
				description = resultset.getString(7);
				ProfessorRequest curpr = new ProfessorRequest(pname,age,exp,cid,course,user_name,description);
				pr.add(curpr);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return pr;
	}
}
