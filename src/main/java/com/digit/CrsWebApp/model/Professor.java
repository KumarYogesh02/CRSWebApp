package com.digit.CrsWebApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Professor {
	int pid;
	String pname;
	int age;
	int exp;
	int cid;
	String course;
	String user_name;
	String password;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	private Statement stmt;
	private ResultSet resultset;
	
	public Professor() {
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
	
	public Professor(int pid, String pname, int age, int exp, int cid, String course, String user_name, String password) {
		this.pid = pid;
		this.pname = pname;
		this.age = age;
		this.exp = exp;
		this.cid = cid;
		this.course = course;
		this.user_name = user_name;
		this.password = password;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean ProfessorLogin(String uname, String pword) {
		try {
			pstmt = con.prepareStatement("select * from professor where user_name=? and password=?");
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
	
	public boolean remProf(int pid) {
		try {
			pstmt = con.prepareStatement("delete from professor where pid = ?");
			pstmt.setInt(1, pid);
			
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
	
	public boolean addProf(String uname) {
		try {
			
			pstmt = con.prepareStatement("select * from professorrequest where user_name=?");
			pstmt.setString(1, uname);
			resultset = pstmt.executeQuery();
			while(resultset.next()==true) {

				this.pname = resultset.getString(1);
				this.age = resultset.getInt(2);
				this.exp = resultset.getInt(3);
				this.cid = resultset.getInt(4);
				this.course = resultset.getString(5);
				this.user_name = resultset.getString(6);
			}
			
			pstmt = con.prepareStatement("insert into professor(pname, age, exp, cid, course, user_name, password)  values(?,?,?,?,?,?,?)");
			pstmt.setString(1, pname);
			pstmt.setInt(2, age);
			pstmt.setInt(3, exp);
			pstmt.setInt(4, cid);
			pstmt.setString(5, course);
			pstmt.setString(6, user_name);
			pstmt.setString(7,"professor");
			
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
	
	public boolean remProfReq(String uname) {
		try {
			pstmt = con.prepareStatement("delete from professorrequest where user_name = ?");
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
	
	public boolean changeName(String nn, String u) {
		try {
            	pstmt = con.prepareStatement("update professor set pname = ? where user_name = ?");
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
	
	public boolean changeExp(String nm, String u) {
		try {
            	pstmt = con.prepareStatement("update professor set exp = ? where user_name = ?");
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
            	pstmt = con.prepareStatement("update professor set password = ? where user_name = ?");
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
	
	public ArrayList<Professor> Ps() {
		ArrayList<Professor> p = new ArrayList<Professor>();
		try {
			
			stmt = con.createStatement();
			resultset = stmt.executeQuery("select * from professor");
			
			while(resultset.next()==true) {
				
				pid = resultset.getInt(1);
				pname = resultset.getString(2);
				age = resultset.getInt(3);
				exp = resultset.getInt(4);
				cid = resultset.getInt(5);
				course = resultset.getString(6);
				user_name = resultset.getString(7);
				password = resultset.getString(8);
				Professor curp = new Professor(pid,pname,age,exp,cid,course,user_name,password);
				p.add(curp);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}
