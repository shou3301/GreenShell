/**
 * 
 */
package org.humble.greensh.frontvo;

/**
 * @author cshou
 * 
 */
public class AdvancedUserInput extends UserInput {

	protected String multiplierNum;
	protected String lightWatts;
	protected String uFactor;
	protected String wallInsulation;
	protected String roofInsulation;
	protected String floorInsulation;
	protected String equipmentWatts;
	protected String airChange;
	protected String coolingRate;
	protected String heatRate;
	protected String heatEfficiency;
	
	public String toString() {
		return super.toString() + 
				"\nMultiplier Number:" + multiplierNum +
				"\nLights Watts per zone Floor Area {W/m2}:" + lightWatts +
				"\nU-Factor:" + uFactor +
				"\nWall Insulation:" + wallInsulation +
				"\nRoof Insulation:" + roofInsulation +
				"\nFloor Insulation:" + floorInsulation +
				"\nEquipment Watts per zone Floor Area {W/m2}:" + equipmentWatts +
				"\nAir Changes per Hour:" + airChange +
				"\nCooling Coil Rated COP {W/W}:" + coolingRate +
				"\nHeat Pump Heating Coil Rated COP {W/W}:" + heatRate +
				"\nGas Heating Coil Efficiency {W/W}:" + heatEfficiency;
	}

	public String getLightWatts() {
		return lightWatts;
	}

	public void setLightWatts(String lightWatts) {
		this.lightWatts = lightWatts;
	}

	public String getuFactor() {
		return uFactor;
	}

	public void setuFactor(String uFactor) {
		this.uFactor = uFactor;
	}

	public String getWallInsulation() {
		return wallInsulation;
	}

	public void setWallInsulation(String wallInsulation) {
		this.wallInsulation = wallInsulation;
	}

	public String getRoofInsulation() {
		return roofInsulation;
	}

	public void setRoofInsulation(String roofInsulation) {
		this.roofInsulation = roofInsulation;
	}

	public String getFloorInsulation() {
		return floorInsulation;
	}

	public void setFloorInsulation(String floorInsulation) {
		this.floorInsulation = floorInsulation;
	}

	public String getEquipmentWatts() {
		return equipmentWatts;
	}

	public void setEquipmentWatts(String equipmentWatts) {
		this.equipmentWatts = equipmentWatts;
	}

	public String getAirChange() {
		return airChange;
	}

	public void setAirChange(String airChange) {
		this.airChange = airChange;
	}

	public String getCoolingRate() {
		return coolingRate;
	}

	public void setCoolingRate(String coolingRate) {
		this.coolingRate = coolingRate;
	}

	public String getHeatEfficiency() {
		return heatEfficiency;
	}

	public void setHeatEfficiency(String heatEfficiency) {
		this.heatEfficiency = heatEfficiency;
	}

	public String getMultiplierNum() {
		return multiplierNum;
	}

	public void setMultiplierNum(String multiplierNum) {
		this.multiplierNum = multiplierNum;
	}

	public String getHeatRate() {
		return heatRate;
	}

	public void setHeatRate(String heatRate) {
		this.heatRate = heatRate;
	}

}
