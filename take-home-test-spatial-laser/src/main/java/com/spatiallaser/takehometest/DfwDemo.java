package com.spatiallaser.takehometest;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

//import org.geolatte.geom.Geometry;

/**
 * @author Tommy Chiu
 */
// tag::code[]
@Entity // <1>
@Table(name = "dfw_demo", schema = "public")
@NamedNativeQuery(
		name = "DfwDemo.findAllForDisp", 
		query = "Select d.\"Key\" as key, d.income, d.population, ST_AsGeoJSON(d.\"SpatialObj\") as spatialObj From public.dfw_demo d",
		resultSetMapping = "Mapping.DfwDemoDto")
@SqlResultSetMapping(
		name = "Mapping.DfwDemoDto",
		classes = @ConstructorResult(targetClass = DfwDemoDto.class,
		columns = {@ColumnResult(name = "key"),
				@ColumnResult(name = "income"),
				@ColumnResult(name = "population"),
				@ColumnResult(name = "spatialObj")}))
public class DfwDemo {

	@Id
	@GeneratedValue
	@Column(name = "\"Key\"")
	private String key;
	
	@Column(name = "income")
	private int income;
	
	@Column(name = "population")
	private int population;
	
	@Column(name = "\"SpatialObj\"", columnDefinition = "geometry")
	private String spatialObj;

	private DfwDemo() {}

	public DfwDemo(int income, int population, String spatialObj) {
		this.income = income;
		this.population = population;
		this.spatialObj = spatialObj;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DfwDemo dfw = (DfwDemo) o;
		return //Objects.equals(id, dfw.id) &&
			Objects.equals(key, dfw.key) &&
			Objects.equals(income, dfw.income) &&
			Objects.equals(population, dfw.population) &&
			Objects.equals(spatialObj, dfw.spatialObj);
	}

	@Override
	public int hashCode() {

		//return Objects.hash(id, income, population, spatialObj);
		return Objects.hash(key, income, population, spatialObj);
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

	@Override
	public String toString() {
		return "DfwDemo{" +
			"key=" + key +
			", income='" + income + '\'' +
			", population='" + population + '\'' +
			", spatialObj='" + spatialObj + '\'' +
			'}';
	}
}
// end::code[]
