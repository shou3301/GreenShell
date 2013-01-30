/**
 * 
 */
package org.humble.greensh.eplus.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.humble.greensh.eplus.vo.EntityAttribute;

/**
 * @author cshou
 *
 */
public class TemplatePool {
	
	private Map<String, Map<String, String>> templates;
	private Map<String, EntityAttribute> entityInfo;
	private Set<String> places;
	
	public TemplatePool() {
		this.templates = new HashMap<String, Map<String, String>>();
		this.places = new HashSet<String>();
		this.entityInfo = new HashMap<String, EntityAttribute>();
	}
	
	// cannot insert an entry with same type and same name
	public boolean insertTemplate(String type, String name, String path) {
		if (this.templates.containsKey(type)) {
			if (templates.get(type).containsKey(name)) {
				return false;
			}
			else {
				((Map)templates.get(type)).put(name, path);
			}
		}
		else {
			Map<String, String> nameMap = new HashMap<String, String>();
			nameMap.put(name, path);
			templates.put(type, nameMap);
		}
		return true;
	}
	
	// if find an entry, return the path; otherwise, return null
	public String findPath(String type, String name) {
		String result = null;
		if (this.templates.containsKey(type)) {
			if (this.templates.get(type).containsKey(name))
				return this.templates.get(type).get(name);
		}
		return result;
	}
	
	public boolean insertEntityInfo(String key, EntityAttribute value) {
		if (this.entityInfo.containsKey(key))
			return false;
		
		this.entityInfo.put(key, value);
		
		return true;
	}
	
	public boolean insertPlace(String place) {
		
		if (this.places.contains(place))
			return false;
		
		this.places.add(place);
		
		return true;
	}
	
	public Map<String, Map<String, String>> getTemplates() {
		return Collections.unmodifiableMap(this.templates);
	}
	
	public Set<String> getPlaces() {
		return Collections.unmodifiableSet(this.places);
	}
	
	public Map<String, EntityAttribute> getEntityInfo() {
		return Collections.unmodifiableMap(this.entityInfo);
	}
	
	@Override
	public String toString() {
		return "Templates: " + templates.toString() + 
				"\nInfo: " + entityInfo.toString() + 
				"\nPlaces; " + places.toString();
	}

}
