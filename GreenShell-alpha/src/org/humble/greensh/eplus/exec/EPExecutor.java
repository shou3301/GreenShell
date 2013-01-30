/**
 * 
 */
package org.humble.greensh.eplus.exec;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.humble.greensh.intl.Executor;

/**
 * @author cshou
 * 
 */
public class EPExecutor implements Executor {

	private String idfPath;
	private String epwPath;
	private String epPath;

	public EPExecutor(String epPath, String idfPath, String epwPath) {
		this.epPath = epPath;
		this.idfPath = idfPath;
		this.epwPath = epwPath;
	}

	@Override
	public String exec() {

		String cmd = epPath + " " + idfPath + " " + epwPath;

		System.out.println(cmd);

		/*try {
			
			Process runner = Runtime.getRuntime().exec(cmd);

			BufferedReader is = new BufferedReader(new InputStreamReader(
					runner.getInputStream()));
			String line;
			while ((line = is.readLine()) != null)
				System.out.println(line);
				//;

			//runner.waitFor();
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}*/
		
		try {
			
			Process runner = Runtime.getRuntime().exec(cmd);
			Worker worker = new Worker(runner);
			worker.start();
			long timeout = 240000L;
			worker.join(timeout);
			
			if (worker.getExit() != 0) {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return idfPath;
	}

}