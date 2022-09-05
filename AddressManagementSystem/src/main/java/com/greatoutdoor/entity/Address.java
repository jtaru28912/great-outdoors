package com.greatoutdoor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addressInfo")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// generationtype identity means persistance provider must assign the primary
	// key using a db id column
	private long addressId;
	private String buildingNo;
	private String streetName;
	private String area;
	private String city;
	private String state;
	private String zip;

	// default constructor
	public Address() {
		super();
	}

	// parameterized constructor
	public Address(long addressId, String buildingNo, String streetName, String area, String city, String state,
			String zip) {
		super();
		this.addressId = addressId;
		this.buildingNo = buildingNo;
		this.streetName = streetName;
		this.area = area;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	// getters and setters
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
