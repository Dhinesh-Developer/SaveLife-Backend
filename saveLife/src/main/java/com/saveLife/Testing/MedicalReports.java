package com.saveLife.Testing;

import java.util.List;

import com.saveLife.Model.MedicalRecords;
import com.saveLife.Service.MedicalReportService;
import com.saveLife.ServiceImpl.MedicalReportServiceImpl;

public class MedicalReports {
	public static void main(String[] args) {
		
		MedicalRecords mr = new MedicalRecords();
		MedicalReportService mrs = new MedicalReportServiceImpl();
		List<MedicalRecords> li = mrs.fetchAll();
		for(MedicalRecords l : li) {
			System.out.println(l);
		}
	}
}
