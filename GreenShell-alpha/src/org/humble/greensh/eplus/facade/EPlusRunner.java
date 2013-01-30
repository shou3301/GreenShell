/**
 * 
 */
package org.humble.greensh.eplus.facade;

import java.util.List;

import org.humble.greensh.intl.Executor;

/**
 * @author cshou
 *
 */
public class EPlusRunner {
	
	private static EPlusRunner epRunner = null;
	
	private EPlusRunner() {
		
	}
	
	public synchronized static EPlusRunner getEPlusRunner() {
		if (epRunner == null) {
			epRunner = new EPlusRunner();
		}
		return epRunner;
	}
	
	public synchronized boolean runJobs(List<Executor> jobList) {
		boolean isSuccess = true;
		
		for (int i = 0; i < jobList.size(); i++) {
			if (jobList.get(i).exec() == null)
				isSuccess = false;
		}
		
		return isSuccess;
	}

}
