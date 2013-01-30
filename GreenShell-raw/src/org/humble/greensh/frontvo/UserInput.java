/**
 * 
 */
package org.humble.greensh.frontvo;

/**
 * @author cshou This class is due to be changed soon.
 */
public class UserInput {

	protected String model;
	protected String schedule;
	protected String window;
	protected String wall;
	protected String floor;
	protected String roof;
	protected String lighting;
	protected String air;
	protected String hvac;
	protected String heat;
	protected String control;
	protected String photovoltaic;
	protected String wind;
	protected String solar;
	protected String geo;
	protected String evaporat;
	protected String shading;
	protected String rain;
	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getPhotovoltaic() {
		return photovoltaic;
	}

	public void setPhotovoltaic(String photovoltaic) {
		this.photovoltaic = photovoltaic;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getSolar() {
		return solar;
	}

	public void setSolar(String solar) {
		this.solar = solar;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getEvaporat() {
		return evaporat;
	}

	public void setEvaporat(String evaporat) {
		this.evaporat = evaporat;
	}

	public String getShading() {
		return shading;
	}

	public void setShading(String shading) {
		this.shading = shading;
	}

	public String getRain() {
		return rain;
	}

	public void setRain(String rain) {
		this.rain = rain;
	}

	protected String place;

	@Override
	public String toString() {
		String res = "Model: " + model + 
				"\nSchedule: " + schedule +
				"\nWindow: " + window +
				"\nWall: " + wall +
				"\nFloor: " + floor +
				"\nRoof: " + roof +
				"\nLighting: " + lighting +
				"\nAir: " + air +
				"\nHvac: " + hvac +
				"\nHeat: " + heat +
				"\nControl: " + control +
				"\nPhoto: " + photovoltaic +
				"\nWind: " + wind +
				"\nSolar: " + solar +
				"\nGeo: " + geo +
				"\nEvaporat: " + evaporat +
				"\nShading: " + shading +
				"\nRain: " + rain +
				"\nPlace: " + place;
		return res;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getWindow() {
		return window;
	}

	public void setWindow(String window) {
		this.window = window;
	}

	public String getWall() {
		return wall;
	}

	public void setWall(String wall) {
		this.wall = wall;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRoof() {
		return roof;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	public String getLighting() {
		return lighting;
	}

	public void setLighting(String lighting) {
		this.lighting = lighting;
	}

	public String getAir() {
		return air;
	}

	public void setAir(String air) {
		this.air = air;
	}

	public String getHvac() {
		return hvac;
	}

	public void setHvac(String hvac) {
		this.hvac = hvac;
	}

	public String getHeat() {
		return heat;
	}

	public void setHeat(String heat) {
		this.heat = heat;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
