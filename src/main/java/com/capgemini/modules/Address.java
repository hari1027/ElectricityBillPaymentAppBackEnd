package com.capgemini.modules;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="address")
public class Address {
	@Id
	public long addressId;
	public int flatOrHouseNumber;
	@NotNull(message = "This field should not be empty")
	@Pattern(regexp="[A-Za-z_]*",message="Invalid buildingName ,Only Alphabets are allowed")
	private String buildingName;
	@NotNull(message = "This field should not be empty")
	@Pattern(regexp="[a-zA-Z0-9]*",message="Invalid landmark ,No special characters are allowed")
	private String landmark;
	@NotNull(message="This field should not be empty")
	@Pattern(regexp="[A-Za-z_]*",message="Invalid village ,Only Alaphabetsare allowed")
	private String village;
	@Pattern(regexp="[A-Za-z0-9]*",message="Invalid taluka ,No special characters are allowed")
	private String taluka;
	@NotNull(message="This field should not be empty")
	@Pattern(regexp="[A-Z]{1}[A-Za-z]*",message="Invalid district ,Only Alaphabets are allowed")
	private String district;
	@NotNull
	@Pattern(regexp="[A-Z]{1}[A-Za-z]*",message="Invalid state ,First letter should be capital ,Only Alphabets are allowed")
	private String state;
	@NotNull
	@Pattern(regexp="[0-9]{6}",message="Invalid pincode ,It should be six digits")
	private String pincode;
	
	public Address() {
	}

	public Address(long addressId, int flatOrHouseNumber, String buildingName, String landmark, String village,
			String taluka, String district, String state, String pincode) {
		this.addressId = addressId;
		this.flatOrHouseNumber = flatOrHouseNumber;
		this.buildingName = buildingName;
		this.landmark = landmark;
		this.village = village;
		this.taluka = taluka;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public int getFlatOrHouseNumber() {
		return flatOrHouseNumber;
	}

	public void setFlatOrHouseNumber(int flatOrHouseNumber) {
		this.flatOrHouseNumber = flatOrHouseNumber;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatOrHouseNumber=" + flatOrHouseNumber + ", buildingName="
				+ buildingName + ", landmark=" + landmark + ", village=" + village + ", taluka=" + taluka
				+ ", district=" + district + ", state=" + state + ", pincode=" + pincode + "]";
	
		
	}

}
