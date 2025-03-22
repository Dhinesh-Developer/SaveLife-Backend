package com.saveLife.Testing;

import java.util.List;

import com.saveLife.Model.Hospital;
import com.saveLife.Service.HospitalService;
import com.saveLife.ServiceImpl.HospitalServiceImpl;

public class HospitalTesting {

	public static void main(String[] args) {
		
		Hospital h = new Hospital();
		HospitalService hs = new HospitalServiceImpl();
		List<Hospital> fetchAll = hs.fetchAll();
		System.out.println(fetchAll);
		
	}

}
