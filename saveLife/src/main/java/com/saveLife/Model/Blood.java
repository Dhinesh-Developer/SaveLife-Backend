package com.saveLife.Model;

public class Blood {
	private int bId;
	private String bloodType;
	private int quantity;
	private boolean critical;
	private int hId;
	@Override
	public String toString() {
		return "Blood [bId=" + bId + ", bloodType=" + bloodType + ", quantity=" + quantity + ", critical=" + critical
				+ ", hId=" + hId + "]";
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isCritical() {
		return critical;
	}
	public void setCritical(boolean critical) {
		this.critical = critical;
	}
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public Blood(int bId, String bloodType, int quantity, boolean critical, int hId) {
		super();
		this.bId = bId;
		this.bloodType = bloodType;
		this.quantity = quantity;
		this.critical = critical;
		this.hId = hId;
	}
	public Blood(String bloodType, int quantity, boolean critical, int hId) {
		super();
		this.bloodType = bloodType;
		this.quantity = quantity;
		this.critical = critical;
		this.hId = hId;
	}
	
	public Blood() {
	}
}
