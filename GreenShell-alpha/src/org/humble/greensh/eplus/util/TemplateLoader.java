/**
 * 
 */
package org.humble.greensh.eplus.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.humble.greensh.eplus.vo.EntityAttribute;
import org.humble.greensh.intl.Executor;

/**
 * @author cshou
 * 
 */
public class TemplateLoader {

	public static TemplatePool generateTemplatePool(String templateConfig, String weatherConfig) {
		
		TemplatePool templatePool = new TemplatePool();
		
		try {

			FileInputStream fstream = new FileInputStream(templateConfig);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String line = null;
			while ((line = br.readLine()) != null) {
				
				String[] vals = line.split(":");
				templatePool.insertTemplate(vals[0], vals[1], vals[2]);
				
				FileInputStream innerFstream = new FileInputStream(vals[2] + ".info");
				DataInputStream innerIn = new DataInputStream(innerFstream);
				BufferedReader innerBr = new BufferedReader(new InputStreamReader(innerIn));
				
				String innerLine = null;
				EntityAttribute entityAttribute = new EntityAttribute();
				while ((innerLine = innerBr.readLine()) != null) {
					
					if (!innerLine.isEmpty()) {
						String[] args = innerLine.split(":");
						entityAttribute.addAttribute(args[0].trim(), args[1].trim());
					}
					
				}
				templatePool.insertEntityInfo(vals[0]+vals[1], entityAttribute);
				
				innerBr.close();
				
			}

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		try {

			FileInputStream fstream = new FileInputStream(weatherConfig);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String line = null;
			while ((line = br.readLine()) != null) {
				
				templatePool.insertPlace(line.trim());
			}

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return templatePool;
	}

}
