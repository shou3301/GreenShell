/**
 * 
 */
package org.humble.greensh.eplus.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author cshou
 * 
 */
public class ConfigReader {

	private final static String configPath = "util\\greensh.config";

	public static ConfigInfo getEPExecutable() {

		String epExec;
		String idfBaseDir;
		String epwBaseDir;
		String templateDir;
		String postProcDir;
		
		try {
			
			FileInputStream fstream = new FileInputStream(configPath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			epExec = br.readLine().trim();
			idfBaseDir = br.readLine().trim();
			epwBaseDir = br.readLine().trim();
			templateDir = br.readLine().trim();
			postProcDir = br.readLine().trim();
			
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		ConfigInfo configInfo = new ConfigInfo(epExec, idfBaseDir, epwBaseDir, templateDir, postProcDir);
		
		return configInfo;
		
	}
}
