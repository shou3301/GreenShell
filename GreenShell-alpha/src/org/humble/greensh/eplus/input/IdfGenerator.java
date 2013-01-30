/**
 * 
 */
package org.humble.greensh.eplus.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.humble.greensh.eplus.util.TemplateLoader;
import org.humble.greensh.eplus.util.TemplatePool;
import org.humble.greensh.intl.Executor;

/**
 * @author cshou
 *
 */
public class IdfGenerator implements Executor {

	protected final int BUFFER_SIZE = 1024;
	
	protected TemplatePool templatePool;
	protected Map<String, String> choosenTemplates;
	protected String targetFile;
	
	public IdfGenerator(String headerPath, String targetFile, TemplatePool templatePool,
			Map<String, String> choosenTemplates) {
		
		this.templatePool = templatePool;
		// System.out.println(this.templatePool);
		this.choosenTemplates = choosenTemplates;
		this.targetFile = targetFile + ".idf";
		
	}
	
	@Override
	public String exec() {
		
		if (this.generateIdf())
			return this.targetFile;
		
		return null;
	}
	
	// please remember to add "enter" at the end of the file
	protected boolean generateIdf() {
		
		try {
			OutputStream out = new FileOutputStream(this.targetFile);
			
			byte[] buf = new byte[BUFFER_SIZE];
		    for (String key : this.choosenTemplates.keySet()) {
		    	
		    	String file = this.templatePool.findPath(key, this.choosenTemplates.get(key));
		    	
		    	System.out.println("key:" + key + " file:" + file);
		    	
		        InputStream in = new FileInputStream(file);
		        int b = 0;
		        while ( (b = in.read(buf)) >= 0) {
		            out.write(buf, 0, b);
		            out.flush();
		        }
		        in.close();
		    }
		    
		    out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public Map<String, String> getChoosenTemplates() {
		return choosenTemplates;
	}

	public void setChoosenTemplates(Map<String, String> choosenTemplates) {
		this.choosenTemplates = choosenTemplates;
	}

	public String getTargetDir() {
		return targetFile;
	}

	public void setTargetDir(String targetFile) {
		this.targetFile = targetFile;
	}

}
