package com.nt;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {

    // Show Date on Web Browser

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // job of the servlet
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        Date d = new Date();
        pw.write("<h1 style='color:red;'>Current time is </h1>" + d);
        pw.close();
    }
}
