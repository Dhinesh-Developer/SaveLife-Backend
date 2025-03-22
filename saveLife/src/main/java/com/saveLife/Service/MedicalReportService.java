package com.saveLife.Service;

import java.util.List;

import com.saveLife.Model.MedicalRecords;

public interface MedicalReportService {
	List<MedicalRecords> fetchAll();
	int update(MedicalRecords medicalrecords);
	MedicalRecords fetchById(int mrId);
}
