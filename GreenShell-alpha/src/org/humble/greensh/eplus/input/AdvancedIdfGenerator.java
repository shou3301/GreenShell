/**
 * 
 */
package org.humble.greensh.eplus.input;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

import org.humble.greensh.eplus.util.TemplatePool;

/**
 * @author cshou
 *
 */
public class AdvancedIdfGenerator extends IdfGenerator {

	protected Map<String, String> params = null;
	
	public AdvancedIdfGenerator(String headerPath, String targetFile,
			TemplatePool templatePool, Map<String, String> choosenTemplates,
			Map<String, String> params) {
		
		super(headerPath, targetFile, templatePool, choosenTemplates);
		this.params = params;
	
	}
	
	
	@Override
	protected boolean generateIdf () {
		
		try {
			FileWriter fw = new FileWriter(super.targetFile);
			BufferedWriter bf = new BufferedWriter(fw);
			
		    for (String key : this.choosenTemplates.keySet()) {
		    	
		    	String file = this.templatePool.findPath(key, this.choosenTemplates.get(key));
		    	
		    	FileInputStream fs = new FileInputStream(file);
		    	BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		    	
		    	String line = null;
		    	while ((line = br.readLine()) != null) {
		    		
		    		// walk through the params
		    		for (String k : params.keySet()) {
		    			if (line.indexOf(k) != -1) {
		    				line = "\t" + params.get(k) + ",\t\t\t\t!-" + k;
		    				break;
		    			}
		    		}
		    		
		    		bf.write(line);
		    		bf.newLine();
		    		
		    	}
		    	
		    	br.close();
		    	fs.close();
		    }
		    
		    bf.close();
		    fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
