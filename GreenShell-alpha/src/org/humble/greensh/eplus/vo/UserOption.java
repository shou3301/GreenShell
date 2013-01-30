/**
 * 
 */
package org.humble.greensh.eplus.vo;

import java.util.Map;

/**
 * @author cshou
 * 
 */
public class UserOption {

	private Map<String, String> choosenTemplate;
	private String place;

	public UserOption(Map<String, String> choosenTemplate, String place) {
		super();
		this.choosenTemplate = choosenTemplate;
		this.place = place;
	}

	public Map<String, String> getChoosenTemplate() {
		return choosenTemplate;
	}

	public void setChoosenTemplate(Map<String, String> choosenTemplate) {
		this.choosenTemplate = choosenTemplate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
