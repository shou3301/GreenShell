package org.humble.greensh.eplus.facade;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.humble.greensh.eplus.util.GreenShInfo;
import org.humble.greensh.eplus.vo.CsvResult;
import org.humble.greensh.eplus.vo.UserOption;
import org.humble.greensh.intl.ExecutorFactory;
import org.junit.Test;

public class EPlusRunnerTest {

	@Test
	public void testRunJobs() {

		GreenShInfo gsi = GreenShInfo.getGreenShInfo();
		
		// System.out.println(gsi);
		if (!gsi.isSuccess()) {
			System.out.println("Error!");
			return;
		}
		
		
		Map<String, String> choosenTemplate = new HashMap<String, String>();
		
		choosenTemplate.put("door", "name1");
		choosenTemplate.put("window", "name1");

		UserOption uo = new UserOption(choosenTemplate, "USA_CA_San.Francisco.Intl.AP.724940_TMY3");
		
		CsvResult res = new CsvResult();
		
		ExecutorFactory factory = new EPlusExecFactory(gsi, uo, res);
		
		EPlusRunner epRunner = EPlusRunner.getEPlusRunner();
		boolean success = epRunner.runJobs(factory.getExecList());
		
		if (!success) {
			System.out.println("Error!");
			return;
		}
		
		System.out.println(res);
	}

}
