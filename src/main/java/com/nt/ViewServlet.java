package com.nt;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.EmpDao;
import com.nt.entity.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;



public class ViewServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		
		EmpDao dao = new EmpDao();
		List<Employee> list= dao.viewDao();
		
		req.setAttribute("empList", list);
		RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
		rd.forward(req, res);
		
	}

}
