/**
 * 
 */
package org.humble.greensh.util;

import java.util.HashMap;
import java.util.Map;

import org.humble.greensh.frontvo.AdvancedUserInput;
import org.humble.greensh.frontvo.UserInput;

/**
 * @author cshou
 *
 */
public class AdvancedUserInputProcessor extends UserInputProcessor {

	private AdvancedUserInput userInput;
	
	public AdvancedUserInputProcessor (UserInput userInput) {
		super(userInput);
		this.userInput = (AdvancedUserInput) userInput;
	}
	
	public Map<String, String> getComments () {
		
		Map<String, String> params = new HashMap<String, String>();
		
		
		if (userInput.getMultiplierNum() != null && !userInput.getMultiplierNum().equals(""))
			params.put("Model_Zone_Multiplier", userInput.getMultiplierNum());
		if (userInput.getWallInsulation() != null && !userInput.getWallInsulation().equals(""))
			params.put("Wall_Wall_Conductivity", userInput.getWallInsulation());
		if (userInput.getRoofInsulation() != null && !userInput.getRoofInsulation().equals(""))
			params.put("Wall_Roof_Conductivity", userInput.getRoofInsulation());
		if (userInput.getFloorInsulation() != null && !userInput.getFloorInsulation().equals(""))
			params.put("Wall_Floor_Conductivity", userInput.getFloorInsulation());
		if (userInput.getuFactor() != null && !userInput.getuFactor().equals(""))
			params.put("Window_U_Factor", userInput.getuFactor());
		if (userInput.getCoolingRate() != null && !userInput.getCoolingRate().equals(""))
			params.put("HVAC_Cooling_Coil_Rated", userInput.getCoolingRate());
		if (userInput.getHeatEfficiency() != null && !userInput.getHeatEfficiency().equals(""))
			params.put("HVAC_Gas_Heating", userInput.getHeatEfficiency());
		if (userInput.getHeatRate() != null && !userInput.getHeatRate().equals(""))
			params.put("HVAC_Heat_Pump", userInput.getHeatRate());
		if (userInput.getLightWatts() != null && !userInput.getLightWatts().equals(""))
			params.put("Schedule_Lights_Watts", userInput.getLightWatts());
		if (userInput.getEquipmentWatts() != null && !userInput.getEquipmentWatts().equals(""))
			params.put("Schedule_ElectricEquipment_Watts", userInput.getEquipmentWatts());
		if (userInput.getAirChange() != null && !userInput.getAirChange().equals(""))
			params.put("Schedule_Flowrate_Air", userInput.getAirChange());
		
		System.out.println(params);
		
		return params;
	}
}
