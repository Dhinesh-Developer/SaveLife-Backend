package com.saveLife.Testing;

import java.util.List;

import com.saveLife.Model.Patient;
import com.saveLife.Service.PatientService;
import com.saveLife.ServiceImpl.PatientServiceImpl;

public class PatientTest {
	public static void main(String[] args) {
		
		
		Patient p = new Patient();
		PatientService ps = new PatientServiceImpl();
		List<Patient> fetchAll = ps.fetchAll();
		System.out.println(fetchAll);
		
	
	//	Patient p1 = new Patient("John Doe", 1001, 1985-06-15, "O+", "Diabetes"," Hypertension", "Metformin, Insulin", "9876543210");
		
		Patient fetchById = ps.fetchById(1001);
		System.out.println(fetchById);
		
	}
}
