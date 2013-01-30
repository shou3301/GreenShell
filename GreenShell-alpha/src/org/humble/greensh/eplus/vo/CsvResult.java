/**
 * 
 */
package org.humble.greensh.eplus.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cshou
 *
 */
public class CsvResult {

	private Map<String, List<Double>> valueMap;
	//private Map<String, List<String>> stringMap;
	
	public CsvResult() {
		setValueMap(new HashMap<String, List<Double>>());
		//stringMap = new HashMap<String, List<String>>();
	}
	
	public Map<String, List<Double>> getValueMap() {
		return this.valueMap;
	}

	public void setValueMap(Map<String, List<Double>> valueMap) {
		this.valueMap = valueMap;
	}
	
	/*public Map<String, List<String>> getStringMap() {
		return this.stringMap;
	}*/
	
	/*public boolean insertString(String key, List<String> slist) {
		if (!this.stringMap.containsKey(key)) {
			this.stringMap.put(key, slist);
			return true;
		}
		return false;
	}*/
	
	public boolean insertDouble(String key, List<Double> dlist) {
		if (!this.valueMap.containsKey(key)) {
			this.valueMap.put(key, dlist);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.valueMap.toString();
	}
}
