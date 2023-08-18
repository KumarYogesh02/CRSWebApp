
package com.digit.CrsWebApp.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Course {
	int cid;
	String cname;
	int fees;
	int dur_months;
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultset;
	
	public Course() {
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
	
	
	public Course(int cid, String cname, int fees, int dur_months) {
		this.cid = cid;
		this.cname = cname;
		this.fees = fees;
		this.dur_months = dur_months;
	}


	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int getDur_months() {
		return dur_months;
	}

	public void setDur_months(int dur_months) {
		this.dur_months = dur_months;
	}
	
	public boolean addCourse(String name, int fee, int duration) {
		try {
			pstmt = con.prepareStatement("insert into course(cname, fees, dur_months) values(?,?,?)");
			pstmt.setString(1, name);
			pstmt.setInt(2, fee);
			pstmt.setInt(3, duration);
			
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
	
	public boolean remCourse(int cid) {
		try {
			pstmt = con.prepareStatement("delete from course where cid = ?");
			pstmt.setInt(1, cid);
			
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
	
	public ArrayList<Course> Courses() {
		ArrayList<Course> c = new ArrayList<Course>();
		try {
			
			stmt = con.createStatement();
			resultset = stmt.executeQuery("select * from course");
			
			while(resultset.next()==true) {
				
				cid = resultset.getInt(1);
				cname = resultset.getString(2);
				fees = resultset.getInt(3);
				dur_months = resultset.getInt(4);
				Course curc = new Course(cid,cname,fees,dur_months);
				c.add(curc);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
		
	}
