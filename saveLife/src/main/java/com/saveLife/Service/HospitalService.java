package com.saveLife.Service;

import java.util.List;

import com.saveLife.Model.Hospital;

public interface HospitalService {
	
	List<Hospital> fetchAll();
	int update(Hospital hospital);
	void delete(int hId);
	Hospital fetchById(int hId);
	int insert(Hospital hospital);
	
	
}
