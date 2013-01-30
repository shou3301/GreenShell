/**
 * 
 */
package org.humble.greensh.eplus.exec;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author cshou
 * 
 */
public class Worker extends Thread {

	private final Process process;
	private Integer exit;

	public Worker(Process process) {
		this.process = process;
		this.exit = 1;
	}

	public void run() {
		
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String line;
			
			while ((line = is.readLine()) != null)
				System.out.println(line);
			
			this.exit = 0;
			
		} catch (Exception ignore) {

			return;
			
		}
		
	}
	
	public Integer getExit() {
		return this.exit;
	}

}
