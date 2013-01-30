/**
 * 
 */
package org.humble.greensh.eplus.util;

/**
 * @author cshou
 * 
 */
public class ConfigInfo {

	private String epExec;
	private String idfBaseDir;
	private String epwBaseDir;
	private String templateConfig;
	private String postProcConfig;

	public String getPostProcConfig() {
		return postProcConfig;
	}

	public ConfigInfo() {

	}

	public ConfigInfo(String epExec, String idfBaseDir, String epwBaseDir,
			String templateDir, String postProcConfig) {
		super();
		this.epExec = epExec;
		this.idfBaseDir = idfBaseDir;
		this.epwBaseDir = epwBaseDir;
		this.templateConfig = templateDir;
		this.postProcConfig = postProcConfig;
	}

	public void setEpExec(String epExec) {
		this.epExec = epExec;
	}

	public String getIdfBaseDir() {
		return idfBaseDir;
	}

	public void setIdfBaseDir(String idfBaseDir) {
		this.idfBaseDir = idfBaseDir;
	}

	public String getEpwBaseDir() {
		return epwBaseDir;
	}

	public void setEpwBaseDir(String epwBaseDir) {
		this.epwBaseDir = epwBaseDir;
	}

	public String getTemplateConfig() {
		return templateConfig;
	}

	public void setTemplateConfig(String templateConfig) {
		this.templateConfig = templateConfig;
	}
	
	public void setPostProcConfig(String postProcConfig) {
		this.postProcConfig = postProcConfig;
	}

	public String getEpExec() {
		return epExec;
	}
	
	@Override
	public String toString() {
		return "EPlus dir: " + this.epExec + "\nIDF dir: " + this.idfBaseDir
				+ "\nWeatherData dir: " + this.epwBaseDir +
				"\nTemplate Dir: " + this.templateConfig;
	}

}
