package com.spatiallaser.takehometest;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tommy Chiu
 */
@Entity
@Table(name = "dfw_view_input", schema = "public")
public class DfwViewInput {

	@Id
	@GeneratedValue
	@Column(name = "key", updatable = false, nullable = false)
	private UUID key;
	
	@Column(name = "lat")
    private double lat;
	
	@Column(name = "lng")
    private double lng;
	
	@Column(name = "buffer")
    private double buffer;
    
	public UUID getKey() {
		return key;
	}

	public void setKey(UUID key) {
		this.key = key;
	}

	public double getLat() {
		return lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public double getLng() {
		return lng;
	}
	
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public double getBuffer() {
		return buffer;
	}
	
	public void setBuffer(double buffer) {
		this.buffer = buffer;
	}

}