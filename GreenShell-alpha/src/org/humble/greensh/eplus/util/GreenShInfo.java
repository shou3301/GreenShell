/**
 * 
 */
package org.humble.greensh.eplus.util;

/**
 * @author cshou
 *
 */
public class GreenShInfo {
	
	private ConfigInfo configInfo = null;
	private TemplatePool templatePool = null;
	private boolean loadSuccess = false;
	
	private static GreenShInfo greenShInfo = null;
	
	private GreenShInfo() {
		// TODO init config info and template pool here
		
		this.configInfo = ConfigReader.getEPExecutable();
		
		if (this.configInfo != null) {
			this.templatePool = TemplateLoader.generateTemplatePool(this.configInfo.getTemplateConfig(), 
					this.configInfo.getEpwBaseDir());
		}
		
		if (this.configInfo != null && this.templatePool != null)
			this.loadSuccess = true;
	}
	
	public synchronized static GreenShInfo getGreenShInfo() {
		if (greenShInfo == null) {
			greenShInfo = new GreenShInfo();
		}
		return greenShInfo;
	}
	
	public ConfigInfo getConfigInfo() {
		return this.configInfo;
	}
	
	public TemplatePool getTemplatePool() {
		return this.templatePool;
	}
	
	public boolean isSuccess() {
		return this.loadSuccess;
	}
	
	@Override
	public String toString() {
		return "ConfigInfo: " + configInfo + "\ntemplatepool:" + 
				templatePool;
	}

}
