/**
 * 
 */
package org.humble.greensh.eplus.output;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.humble.greensh.eplus.vo.CsvResult;
import org.humble.greensh.intl.Executor;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author cshou
 * 
 */
public class CsvParser implements Executor {

	private String configPath;
	private String csvPath;
	private CsvResult result;

	public CsvParser(String configPath, String csvPath, CsvResult result) {
		super();
		this.configPath = configPath;
		this.result = result;
		this.csvPath = csvPath;
	}

	@Override
	public String exec() {

		if (!parse())
			return null;
		
		return "fine";
	}

	private boolean parse() {

		Set<String> interestedKeys = new HashSet<String>();
		
		try {

			FileInputStream fstream = new FileInputStream(this.configPath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String line = null;
			
			while ((line = br.readLine()) != null) {
				interestedKeys.add(line.trim());
			}

			in.close();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		if (!coreParse(interestedKeys))
			return false;

		if (interestedKeys.size() == 0)
			return false;
		
		return true;
	}
	
	private boolean coreParse(Set<String> interestedKeys) {
		try {
			
			System.out.println("Interested keys:" + interestedKeys);
			System.out.println("Read from : " + this.csvPath);
			
			CSVReader reader = new CSVReader(new FileReader(this.csvPath));
			
			String[] title = reader.readNext();
			
			// System.out.println("aaaaa");
			
			System.out.println(Arrays.toString(title));
						
			Map<Integer, String> keys = new HashMap<Integer, String>();
			Map<Integer, List<Double>> rawResult = new HashMap<Integer, List<Double>>();
			for (int i = 0; i < title.length; i++) {
				System.out.println("Title:" + title[i]);
				if (interestedKeys.contains(title[i].trim())) {
					List<Double> col = new ArrayList<Double>();
					rawResult.put(i, col);
					keys.put(i, title[i]);
					System.out.println("find interested key:" + title[i] + ":" + rawResult);
				}
			}
			
			if (rawResult.size() == 0) {
				System.out.println("size is 0");
				reader.close();
				return false;
			}
			
			String[] line = null;
			while ((line = reader.readNext()) != null) {
		        for (Integer idx : rawResult.keySet()) {
		        	rawResult.get(idx).add(Double.parseDouble(line[idx]));
		        }
		    }
			
			reader.close();
			
			for (Integer idx : rawResult.keySet()) {
				this.result.insertDouble(keys.get(idx), rawResult.get(idx));
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public String getConfigPath() {
		return configPath;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	public CsvResult getResult() {
		return result;
	}

	public void setResult(CsvResult result) {
		this.result = result;
	}

	public String getCsvPath() {
		return csvPath;
	}

	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}

}
