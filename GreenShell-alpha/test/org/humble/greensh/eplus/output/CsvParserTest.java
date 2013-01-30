package org.humble.greensh.eplus.output;

import static org.junit.Assert.*;

import org.humble.greensh.eplus.vo.CsvResult;
import org.junit.Test;

public class CsvParserTest {

	@Test
	public void testExec() {
		CsvResult res = new CsvResult();
		CsvParser parser = new CsvParser("PostProcess\\postproc.config", "PostProcess\\test.csv", res);
		parser.exec();
		System.out.println(res);
	}

}
