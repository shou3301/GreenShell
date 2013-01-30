package org.humble.greensh.service;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.humble.greensh.eplus.util.GreenShInfo;
import org.humble.greensh.eplus.vo.EntityAttribute;

import com.google.gson.Gson;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private GreenShInfo greenShInfo;
       
    public InfoServlet() {
        super();
        greenShInfo = GreenShInfo.getGreenShInfo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (!this.greenShInfo.isSuccess()) {
			response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write("");
			return;
		}
		
		// a tomcat problem
		String key = new String(request.getParameter("Info").getBytes("ISO-8859-1"), "utf-8");
		
		Gson gson = new Gson();
		
		System.out.println(key);
		
		EntityAttribute info = this.greenShInfo.getTemplatePool().getEntityInfo().get(key);
		
		String jsonString = gson.toJson(info.getAttributes());
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonString);
	    
	}

}
