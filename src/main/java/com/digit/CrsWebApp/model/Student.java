package com.digit.CrsWebApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	int sid;
	String sname;
	int age;
	String email;
	int cid;
	String course;
	int score;
	String user_name;
	String password;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	private Statement stmt;
	private ResultSet resultset;
	private Object session;
	
	public Student() {
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

	public Student(int sid, String sname, int age, String email, int cid, String course, int score, String user_name, String password) {
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.email = email;
		this.cid = cid;
		this.course = course;
		this.score = score;
		this.user_name = user_name;
		this.password = password;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
	
	public boolean StudentLogin(String uname, String pword) {
		try {
			pstmt = con.prepareStatement("select * from student where user_name=? and password=?");
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
	
	public boolean remStud(int sid) {
		try {
			pstmt = con.prepareStatement("delete from student where sid = ?");
			pstmt.setInt(1, sid);
			
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
	
	public boolean remStudReq(String uname) {
		try {
			pstmt = con.prepareStatement("delete from studentrequest where user_name = ?");
			pstmt.setString(1, uname);
			
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
	
	public boolean addStud(String uname) {
		try {
			
			pstmt = con.prepareStatement("select * from studentrequest where user_name=?");
			pstmt.setString(1, uname);
			resultset = pstmt.executeQuery();
			while(resultset.next()==true) {

				this.sname = resultset.getString(1);
				this.age = resultset.getInt(2);
				this.email = resultset.getString(3);
				this.cid = resultset.getInt(4);
				this.course = resultset.getString(5);
				this.user_name = resultset.getString(6);
			}
			
			pstmt = con.prepareStatement("insert into student(sname, age, email, cid, course, user_name, password)  values(?,?,?,?,?,?,?)");
			pstmt.setString(1, sname);
			pstmt.setInt(2, age);
			pstmt.setString(3, email);
			pstmt.setInt(4, cid);
			pstmt.setString(5, course);
			pstmt.setString(6, user_name);
			pstmt.setString(7,"student");
			
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
	
	public boolean grade(int sid, int score) {
		try {
			
			pstmt = con.prepareStatement("update student set score = ? where sid = ?");
			pstmt.setInt(1, score);
			pstmt.setInt(2, sid);
			
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
	
	public boolean score(String uname) {
		try {
			pstmt = con.prepareStatement("select score from student where user_name=?");
			pstmt.setString(1, uname);
			
			res = pstmt.executeQuery();
			
			if (res.next() == true) {
				this.score = res.getInt(1);
				return true;

			} else {

				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
	
	public boolean scorecard(String uname) {
		try {
			pstmt = con.prepareStatement("select * from student where user_name=?");
			pstmt.setString(1, uname);
			
			res = pstmt.executeQuery();
			
			if (res.next() == true) {
				this.sid = res.getInt(1);
				this.sname = res.getString(2);
				this.user_name = res.getString(8);
				this.age = res.getInt(3);
				this.email = res.getString(4);
				this.cid = res.getInt(5);
				this.course = res.getString(6);
				this.score = res.getInt(7);
				
				return true;
				
			} else {

				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
	
	public boolean changeName(String nn, String u) {
		try {
            	pstmt = con.prepareStatement("update student set sname = ? where user_name = ?");
                pstmt.setString(1, nn);
                pstmt.setString(2, u); 
                
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
	
	public boolean changeMail(String nm, String u) {
		try {
            	pstmt = con.prepareStatement("update student set email = ? where user_name = ?");
                pstmt.setString(1, nm);
                pstmt.setString(2, u); 
                
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
	
	public boolean changePword(String np, String u) {
		try {
            	pstmt = con.prepareStatement("update student set password = ? where user_name = ?");
                pstmt.setString(1, np);
                pstmt.setString(2, u); 
                
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
	

	
	public ArrayList<Student> enrollesstud(String user) {
		ArrayList<Student> s = new ArrayList<Student>();
		try {
			pstmt = con.prepareStatement("select cid from professor where user_name = ?");
			pstmt.setString(1, user);
			resultset = pstmt.executeQuery();
			
			pstmt = con.prepareStatement("select * from student where cid = ?");
			resultset.first();
			pstmt.setInt(1, resultset.getInt(1));
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next()==true) {
				sid = resultset.getInt(1);
				sname = resultset.getString(2);
				age = resultset.getInt(3);
				email = resultset.getString(4);
				cid = resultset.getInt(5);
				course = resultset.getString(6);
				score = resultset.getInt(7);
				user_name = resultset.getString(8);
				password = resultset.getString(9);
				Student curs = new Student(sid,sname,age,email,cid,course,score,user_name,password);
				s.add(curs);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public ArrayList<Student> Ss() {
		ArrayList<Student> s = new ArrayList<Student>();
		try {
			
			stmt = con.createStatement();
			resultset = stmt.executeQuery("select * from student");
			
			while(resultset.next()==true) {
				
				sid = resultset.getInt(1);
				sname = resultset.getString(2);
				age = resultset.getInt(3);
				email = resultset.getString(4);
				cid = resultset.getInt(5);
				course = resultset.getString(6);
				score = resultset.getInt(7);
				user_name = resultset.getString(8);
				password = resultset.getString(9);
				Student curs = new Student(sid,sname,age,email,cid,course,score,user_name,password);
				s.add(curs);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
