package com.spatiallaser.takehometest;

public class DfwDemoDto {
	private String key;
	private int income;
	private int population;
	private String spatialObj;
	
	public DfwDemoDto(String key, int income, int population, String spatialObj) {
		this.key = key;
		this.income = income;
		this.population = population;
		this.spatialObj = spatialObj;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getSpatialObj() {
		return spatialObj;
	}

	public void setSpatialObj(String spatialObj) {
		this.spatialObj = spatialObj;
	}
	
}
