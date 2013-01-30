package org.humble.greensh.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.humble.greensh.eplus.util.GreenShInfo;

import com.google.gson.Gson;

@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private GreenShInfo greenShInfo = null;
       
    public InitServlet() {
        super();
        greenShInfo = GreenShInfo.getGreenShInfo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // response.getWriter().write(System.getProperty("user.dir"));
		
		if (!this.greenShInfo.isSuccess()) {
			response.setContentType("text/plain");
		    response.setCharacterEncoding("utf-8");
		    response.getWriter().write("");
			return;
		}
		
		Gson gson = new Gson();
		
		Map<String, Map<String, String>> templates = this.greenShInfo.getTemplatePool().getTemplates();
		
		Map<String, List<String>> showList = new HashMap<String, List<String>>();
		
		for (String type : templates.keySet()) {
			if (!type.equals("place")) {
				List<String> nameList = new ArrayList<String>();
				for (String value : templates.get(type).keySet()) {
					nameList.add(value);
				}
				showList.put(type, nameList);
			}
		}
		
		List<String> weatherList = new ArrayList<String>();
		weatherList.addAll(this.greenShInfo.getTemplatePool().getPlaces());
		showList.put("place", weatherList);
		
		String jsonString = gson.toJson(showList);
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("utf-8");
	    response.getWriter().write(jsonString);
		
	}

}
