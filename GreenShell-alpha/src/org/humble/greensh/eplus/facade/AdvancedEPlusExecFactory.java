/**
 * 
 */
package org.humble.greensh.eplus.facade;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.humble.greensh.eplus.exec.EPExecutor;
import org.humble.greensh.eplus.input.AdvancedIdfGenerator;
import org.humble.greensh.eplus.input.IdfGenerator;
import org.humble.greensh.eplus.output.CsvParser;
import org.humble.greensh.eplus.util.ConfigInfo;
import org.humble.greensh.eplus.util.GreenShInfo;
import org.humble.greensh.eplus.util.TemplatePool;
import org.humble.greensh.eplus.vo.CsvResult;
import org.humble.greensh.eplus.vo.UserOption;
import org.humble.greensh.intl.Executor;
import org.humble.greensh.intl.ExecutorFactory;

/**
 * @author cshou
 *
 */
public class AdvancedEPlusExecFactory extends ExecutorFactory {
	
	private GreenShInfo greenShInfo = null;
	private UserOption uo = null;
	private CsvResult csvResult = null;
	private Map<String, String> params = null;

	public AdvancedEPlusExecFactory(GreenShInfo greenShInfo, UserOption uo, 
			Map<String, String> params, CsvResult csvResult) {
		this.greenShInfo = greenShInfo;
		this.uo = uo;
		this.csvResult = csvResult;
		this.params = params;
	}

	@Override
	public List<Executor> getExecList() {

		addJobs();
		
		return super.execList;
	}

	private void addJobs() {
		
		super.execList = new ArrayList<Executor>();

		ConfigInfo configInfo = this.greenShInfo.getConfigInfo();
		TemplatePool templatePool = this.greenShInfo.getTemplatePool();
		
		String idfTarget = getTargetName(configInfo.getIdfBaseDir());
		
		// System.out.println("idf target:" + idfTarget);
		
		Executor idf = new AdvancedIdfGenerator("..", idfTarget, templatePool, uo.getChoosenTemplate(), params);
		super.execList.add(idf);
		
		EPExecutor epc = new EPExecutor(configInfo.getEpExec(), idfTarget, uo.getPlace());
		super.execList.add(epc);
		
		Executor parser = new CsvParser(configInfo.getPostProcConfig(), getCsvName(idfTarget), this.csvResult);
		super.execList.add(parser);
		
	}

	// in current version,
	// target file is named as : time-of-the-day/target.idf
	private String getTargetName(String baseDir) {

		Date now = new Date();
		String stringNow = now.toString().replaceAll(" ", "-")
				.replaceAll(":", "-").trim();

		new File(baseDir + stringNow).mkdir();

		return baseDir + stringNow + "\\target";
	}

	private String getCsvName(String targetName) {
		return targetName + "Meter.csv";
	}
	
	public GreenShInfo getGreenShInfo() {
		return greenShInfo;
	}

	public void setGreenShInfo(GreenShInfo greenShInfo) {
		this.greenShInfo = greenShInfo;
	}

	public UserOption getUo() {
		return uo;
	}

	public void setUo(UserOption uo) {
		this.uo = uo;
	}
}
