package com.saveLife.Model;

public class MedicalRecords {
    
    private int mrId;
    private String date;
    
    private String treatment;   
    private String medications; 
    private String notes;      
    private int pId;

    
    public MedicalRecords() {
    }

  
    public MedicalRecords(int mrId, String date,  String treatment, String medications, String notes, int pId) {
        this.mrId = mrId;
        this.date = date;
       
        this.treatment = treatment;
        this.medications = medications;
        this.notes = notes;
        this.pId = pId;
    }

  
    public MedicalRecords(String date, String treatment, String medications, String notes, int pId) {
        this.date = date;
        
        this.treatment = treatment;
        this.medications = medications;
        this.notes = notes;
        this.pId = pId;
    }


    public int getMrId() {
        return mrId;
    }
    public void setMrId(int mrId) {
        this.mrId = mrId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
   
    public String getTreatment() {
        return treatment;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    public String getMedications() {
        return medications;
    }
    public void setMedications(String medications) {
        this.medications = medications;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public int getpId() {
        return pId;
    }
    public void setpId(int pId) {
        this.pId = pId;
    }
}
