package com.saveLife.Model;

import java.sql.Date;

public class Patient {
	
	private int pId;
	private String name;
	private int uniqueId;
	private Date DOB;
	private String bloodType;
	private String conditions;
	private String medications;
	private String emergencyContact;
	
	public Patient(int pId, String name, int uniqueId, Date dOB, String bloodType, String conditions,
			String medications, String emergencyContact) {
		super();
		this.pId = pId;
		this.name = name;
		this.uniqueId = uniqueId;
		DOB = dOB;
		this.bloodType = bloodType;
		this.conditions = conditions;
		this.medications = medications;
		this.emergencyContact = emergencyContact;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getMedications() {
		return medications;
	}
	public void setMedications(String medications) {
		this.medications = medications;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public Patient(String name, int uniqueId, Date dOB, String bloodType, String conditions, String medications,
			String emergencyContact) {
		super();
		this.name = name;
		this.uniqueId = uniqueId;
		DOB = dOB;
		this.bloodType = bloodType;
		this.conditions = conditions;
		this.medications = medications;
		this.emergencyContact = emergencyContact;
	}
	@Override
	public String toString() {
		return "Patinents [pId=" + pId + ", name=" + name + ", uniqueId=" + uniqueId + ", DOB=" + DOB + ", bloodType="
				+ bloodType + ", conditions=" + conditions + ", medications=" + medications + ", emergencyContact="
				+ emergencyContact + "]";
	}
	
	public Patient() {
	}
}
