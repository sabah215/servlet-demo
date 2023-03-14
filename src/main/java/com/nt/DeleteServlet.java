package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.EmpDao;





public class DeleteServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.print(id);
		EmpDao dao = new EmpDao();
		dao.delete(id);
		
		RequestDispatcher rd = req.getRequestDispatcher("deleteSuccess.jsp");
		rd.forward(req, res);
		
	}

}
