package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class DeleteServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test","root","3nt3r_MYSQL");
			
			PreparedStatement ps = con.prepareStatement("delete from tb_employee where id = ?");
			ps.setInt(1, 576);
			ps.executeUpdate();
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter pw = res.getWriter();
		pw.write("<h1>Successfully deleted record</h1>");
		pw.close();
	}

}
