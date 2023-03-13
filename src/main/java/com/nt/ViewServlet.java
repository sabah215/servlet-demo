package com.nt;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;



public class ViewServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		int id;
		String name;
		int salary;
		
		try {
			
			// db connect
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_test", 
					"root",
					"3nt3r_MYSQL");
			
			PreparedStatement st = con.prepareStatement("select * from tb_employee;");
			ResultSet rs = st.executeQuery();
			PrintWriter pw = res.getWriter();
			
			while(rs.next()) {
				id = rs.getInt("id");
				name = rs.getString("name");
				salary = rs.getInt("salary");
				
				System.out.println(id+" "+name+" "+ salary);
				
				pw.write(id+" "+name+" "+ salary+"\n");
				
				res.setContentType("text/html");
			}
			con.close();
			pw.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
