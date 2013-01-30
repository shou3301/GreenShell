package org.humble.greensh.service;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.humble.greensh.eplus.facade.EPlusExecFactory;
import org.humble.greensh.eplus.facade.EPlusRunner;
import org.humble.greensh.eplus.util.GreenShInfo;
import org.humble.greensh.eplus.vo.CsvResult;
import org.humble.greensh.eplus.vo.UserOption;
import org.humble.greensh.frontvo.UserInput;
import org.humble.greensh.intl.Executor;
import org.humble.greensh.intl.ExecutorFactory;
import org.humble.greensh.util.UserInputProcessor;

import com.google.gson.Gson;

@WebServlet("/SimulatorServlet")
public class SimulatorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public SimulatorServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Gson gson = new Gson();
		String rawInput = request.getParameter("UserOption");
		UserInput userInput = gson.fromJson(rawInput, UserInput.class);
		
		System.out.println(userInput);
		
		String placeName = userInput.getPlace();
		
		UserInputProcessor uip = new UserInputProcessor(userInput);
		
		UserOption uo = new UserOption(uip.getChoosenTemplates(), placeName);
		
		CsvResult res = new CsvResult();
		
		ExecutorFactory factory = new EPlusExecFactory(GreenShInfo.getGreenShInfo(), uo, res);
		
		EPlusRunner epRunner = EPlusRunner.getEPlusRunner();
		boolean isSuccess = epRunner.runJobs(factory.getExecList());
		
		if (!isSuccess) {
			response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write("");
			return;
		}
		
		String jsonString = gson.toJson(res.getValueMap());
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonString);
		
	}

}
