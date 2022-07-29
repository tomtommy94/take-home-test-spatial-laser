package com.spatiallaser.takehometest;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tommy Chiu
 */
// tag::code[]
@Entity // <1>
@Table(name = "dfw_view", schema = "public")
public class DfwView {

	@Id
	@GeneratedValue
	@Column(name = "key")
	private String key;
	
	@Column(name = "income")
	private int income;
	
	@Column(name = "population")
	private int population;
	
	@Column(name = "centroid")
	private String centroid;
	
	@Column(name = "spatialObj")
	private String spatialObj;
	
	@Column(name = "isWithinBuffer")
	private boolean isWithinBuffer;

	private DfwView() {}

	public DfwView(int income, int population, String centroid, String spatialObj, boolean isWithinBuffer) {
		this.income = income;
		this.population = population;
		this.centroid = centroid;
		this.spatialObj = spatialObj;
		this.isWithinBuffer = isWithinBuffer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DfwView dfw = (DfwView) o;
		return //Objects.equals(id, dfw.id) &&
			Objects.equals(key, dfw.key) &&
			Objects.equals(income, dfw.income) &&
			Objects.equals(population, dfw.population) &&
			Objects.equals(centroid, dfw.centroid) &&
			Objects.equals(spatialObj, dfw.spatialObj) &&
			Objects.equals(isWithinBuffer, dfw.isWithinBuffer);
	}

	@Override
	public int hashCode() {

		//return Objects.hash(id, income, population, spatialObj);
		return Objects.hash(key, income, population, centroid, spatialObj, isWithinBuffer);
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

	public String getCentroid() {
		return centroid;
	}

	public void setCentroid(String centroid) {
		this.centroid = centroid;
	}

	public String getSpatialObj() {
		return spatialObj;
	}

	public void setSpatialObj(String spatialObj) {
		this.spatialObj = spatialObj;
	}

	public boolean isWithinBuffer() {
		return isWithinBuffer;
	}

	public void setWithinBuffer(boolean isWithinBuffer) {
		this.isWithinBuffer = isWithinBuffer;
	}

	@Override
	public String toString() {
		return "DfwView{" +
			"key='" + key + '\'' +
			", income=" + income +
			", population=" + population +
			", centroid='" + centroid + '\'' +
			", spatialObj='" + spatialObj + '\'' +
			", isWithinBuffer=" + isWithinBuffer +
			'}';
	}
}
// end::code[]
