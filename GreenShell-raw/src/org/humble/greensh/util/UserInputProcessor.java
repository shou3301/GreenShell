/**
 * 
 */
package org.humble.greensh.util;

import java.util.HashMap;
import java.util.Map;

import org.humble.greensh.frontvo.UserInput;

/**
 * @author cshou
 *
 */
public class UserInputProcessor {

	protected UserInput userInput;
	
	public UserInputProcessor (UserInput userInput) {
		this.userInput = userInput;
	}
	
	public Map<String, String> getChoosenTemplates () {
		
		Map<String, String> choosenTemplate = new HashMap<String, String>();
		
		choosenTemplate.put("model", userInput.getModel());
		choosenTemplate.put("schedule", userInput.getSchedule());
		choosenTemplate.put("window", userInput.getWindow());
		choosenTemplate.put("wall", userInput.getWall());
		choosenTemplate.put("floor", userInput.getFloor());
		choosenTemplate.put("roof", userInput.getRoof());
		choosenTemplate.put("lighting", userInput.getLighting());
		choosenTemplate.put("air", userInput.getAir());
		choosenTemplate.put("hvac", userInput.getHvac());
		choosenTemplate.put("heat", userInput.getHeat());
		choosenTemplate.put("place", userInput.getPlace());
		
		return choosenTemplate;
	}
	
}
