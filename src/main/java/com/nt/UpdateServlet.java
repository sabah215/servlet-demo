package com.nt;
import com.nt.dao.EmpDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UpdateServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		EmpDao dao = new EmpDao();
		dao.update(5000, "Peter");
		
		PrintWriter pw = res.getWriter();
		pw.write("<h2> Successfully Updated record</h2>");
		pw.close();	
		
	}

}
