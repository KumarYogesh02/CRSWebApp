package com.digit.CrsWebApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Users {
	String user_name;
	String password;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	
	public Users() {
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean AdminLogin(String uname, String pword) {
		try {
			pstmt = con.prepareStatement("select * from users where user_name=? and password=?");
			pstmt.setString(1, uname);
			pstmt.setString(2, pword);
			res = pstmt.executeQuery();
			if (res.next() == true) {

				return true;

			} else {

				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
}
