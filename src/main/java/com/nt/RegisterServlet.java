package com.nt;
import com.nt.dao.EmpDao;

import java.io.IOException;



import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		// read form data and save to db
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int sal = Integer.parseInt(req.getParameter("salary"));
		
		System.out.println("id: " + id + "Name: "+ name + "Salary:" +sal);
		
		// Call EmpDao
		EmpDao dao = new EmpDao();
		dao.register(id, name, sal);
		
		PrintWriter pw = res.getWriter();
		pw.write("<h3 style='color:red;'>Registration Successful</h3>");
		res.setContentType("text/html");
		pw.close();
		
		
		
	}

}
