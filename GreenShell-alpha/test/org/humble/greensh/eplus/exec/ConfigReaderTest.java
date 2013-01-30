package org.humble.greensh.eplus.exec;

import static org.junit.Assert.*;

import org.humble.greensh.eplus.util.ConfigReader;
import org.junit.Test;

public class ConfigReaderTest {

	@Test
	public void testGetEPExecutable() {
		ConfigReader cr = new ConfigReader();
		System.out.println(cr.getEPExecutable());
	}

}
