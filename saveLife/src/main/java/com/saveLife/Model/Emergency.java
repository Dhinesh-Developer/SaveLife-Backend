package com.saveLife.Model;

public class Emergency {
	private int eId;
	private int pId;
	private int hId;
	private String location;
	private String emergencyType;
	private String symptoms;
	private String vitalSigns;
	private String AiRecommendations;
	private String status;
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmergencyType() {
		return emergencyType;
	}
	public void setEmergencyType(String emergencyType) {
		this.emergencyType = emergencyType;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getVitalSigns() {
		return vitalSigns;
	}
	public void setVitalSigns(String vitalSigns) {
		this.vitalSigns = vitalSigns;
	}
	public String getAiRecommendations() {
		return AiRecommendations;
	}
	public void setAiRecommendations(String aiRecommendations) {
		AiRecommendations = aiRecommendations;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Emergency(int eId, int pId, int hId, String location, String emergencyType, String symptoms,
			String vitalSigns, String aiRecommendations, String status) {
		super();
		this.eId = eId;
		this.pId = pId;
		this.hId = hId;
		this.location = location;
		this.emergencyType = emergencyType;
		this.symptoms = symptoms;
		this.vitalSigns = vitalSigns;
		AiRecommendations = aiRecommendations;
		this.status = status;
	}
	public Emergency(int pId, int hId, String location, String emergencyType, String symptoms, String vitalSigns,
			String aiRecommendations, String status) {
		super();
		this.pId = pId;
		this.hId = hId;
		this.location = location;
		this.emergencyType = emergencyType;
		this.symptoms = symptoms;
		this.vitalSigns = vitalSigns;
		AiRecommendations = aiRecommendations;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Emergency [eId=" + eId + ", pId=" + pId + ", hId=" + hId + ", location=" + location + ", emergencyType="
				+ emergencyType + ", symptoms=" + symptoms + ", vitalSigns=" + vitalSigns + ", AiRecommendations="
				+ AiRecommendations + ", status=" + status + "]";
	}
	
	
	
}
