package org.humble.greensh.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DirServlet")
public class DirServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public DirServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Inside servlet");
		
		String dir = System.getProperty("user.dir");
		
		System.out.println(dir);
		
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(dir);
		
	}

}
