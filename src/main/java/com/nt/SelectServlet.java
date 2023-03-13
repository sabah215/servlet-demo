package com.nt;
import com.nt.dao.*;
import com.nt.entity.Employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		int id= Integer.parseInt(req.getParameter("id"));

		EmpDao dao = new EmpDao();
		Employee e = dao.selectDao(id);
		
		System.out.println(e.getName());
		
		// pass data to jsp
		req.setAttribute("emp", e);
		
		// call display.jsp
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, res);
	}

}
