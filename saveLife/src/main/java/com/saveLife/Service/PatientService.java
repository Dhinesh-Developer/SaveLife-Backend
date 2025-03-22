package com.saveLife.Service;

import java.util.List;

import com.saveLife.Model.Patient;



public interface PatientService {
	List<Patient> fetchAll();
	int update(Patient patient);
	Patient fetchById(int uniqueId);
	void delete(int id);
	int insert(Patient patient);
	
}
