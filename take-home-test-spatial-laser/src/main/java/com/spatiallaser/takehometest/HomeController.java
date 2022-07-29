package com.spatiallaser.takehometest;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tommy Chiu
 */
// tag::code[]
@Controller // <1>
public class HomeController {
	private final DfwViewRepository dfwViewrepository;
	
	@Autowired
	public HomeController(DfwViewRepository dfwViewrepository) {
		this.dfwViewrepository = dfwViewrepository;
	}
	
	@RequestMapping(value = "/") // <2>
	public String index() {
		//Creating a JSONObject object
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("type", "FeatureCollection");
		
		JSONArray features = new JSONArray();
		
		List<DfwView> dfwViewList = dfwViewrepository.findAll();
		for(DfwView d : dfwViewList) {
			JSONObject feature = new JSONObject();
			//Inserting key-value pairs into the json object
			feature.put("type", "Feature");
			
			JSONObject prop = new JSONObject();
			prop.put("key", d.getKey());
			prop.put("income", d.getIncome());
			prop.put("population", d.getPopulation());
			
			feature.put("properties", prop);
			
			JSONParser parser = new JSONParser();
			
			// Centroid marker on map for polygon within range
			if(d.isWithinBuffer()) {
				JSONObject feature2 = new JSONObject();
				feature2.put("type", "Feature");
				feature2.put("properties", prop);
				
				JSONObject cent = null;
				try {
					cent = (JSONObject) parser.parse(d.getCentroid());
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
				feature2.put("geometry", cent);
				
				features.add(feature2);
			}
			
			// Polygon on map
			JSONObject geom = null;
			try {
				geom = (JSONObject) parser.parse(d.getSpatialObj());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			feature.put("geometry", geom);
			
			features.add(feature);
		}
		jsonObject.put("features", features);
		try {
			File f = new ClassPathResource("static/dfw-data.js").getFile();
			FileWriter file = new FileWriter(f);
			file.write("var dfwData = " + jsonObject.toJSONString());
			file.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index"; // <3>
	}
	
}
// end::code[]
