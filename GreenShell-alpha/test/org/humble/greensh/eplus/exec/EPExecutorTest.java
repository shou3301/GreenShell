package org.humble.greensh.eplus.exec;

import static org.junit.Assert.*;

import org.humble.greensh.eplus.exec.EPExecutor;
import org.humble.greensh.eplus.util.ConfigInfo;
import org.humble.greensh.eplus.util.ConfigReader;
import org.junit.Test;

public class EPExecutorTest {

	@Test
	public void testExec() {
		//ConfigReader cr = new ConfigReader();
		//System.out.println(cr.getEPExecutable());
		ConfigInfo ci = ConfigReader.getEPExecutable();
		EPExecutor epc = new EPExecutor(ci.getEpExec(), "C:\\EnergyPlusV7-2-0\\ExampleFiles\\1ZoneEvapCooler", "USA_CA_San.Francisco.Intl.AP.724940_TMY3");
		String res = epc.exec();
		
		if (res == null)
			System.out.println("Error");
	}

}
