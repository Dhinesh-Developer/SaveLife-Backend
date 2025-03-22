package com.saveLife.Model;

public class Hospital {
	private int hId;
	private String name;
	private String location;
	private String contact;
	private String availableBeds;
	private String specialties;
	private String emergencyReady;
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAvailableBeds() {
		return availableBeds;
	}
	public void setAvailableBeds(String availableBeds) {
		this.availableBeds = availableBeds;
	}
	public String getSpecialties() {
		return specialties;
	}
	public void setSpecialties(String specialties) {
		this.specialties = specialties;
	}
	public String getEmergencyReady() {
		return emergencyReady;
	}
	public void setEmergencyReady(String emergencyReady) {
		this.emergencyReady = emergencyReady;
	}
	public Hospital(int hId, String name, String location, String contact, String availableBeds, String specialties,
			String emergencyReady) {
		super();
		this.hId = hId;
		this.name = name;
		this.location = location;
		this.contact = contact;
		this.availableBeds = availableBeds;
		this.specialties = specialties;
		this.emergencyReady = emergencyReady;
	}
	public Hospital(String name, String location, String contact, String availableBeds, String specialties,
			String emergencyReady) {
		super();
		this.name = name;
		this.location = location;
		this.contact = contact;
		this.availableBeds = availableBeds;
		this.specialties = specialties;
		this.emergencyReady = emergencyReady;
	}
	public Hospital() {
	}
	
}
