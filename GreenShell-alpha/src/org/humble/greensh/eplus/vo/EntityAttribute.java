/**
 * 
 */
package org.humble.greensh.eplus.vo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cshou
 *
 */
public class EntityAttribute {
	
	private Map<String, String> attributes;
	
	public EntityAttribute() {
		attributes = new HashMap<String, String>();
	}
	
	public void addAttribute(String key, String value) {
		attributes.put(key, value);
	}
	
	public String getAttribute(String key) {
		return attributes.get(key);
	}
	
	public Map<String, String> getAttributes() {
		return Collections.unmodifiableMap(this.attributes);
	}

}
