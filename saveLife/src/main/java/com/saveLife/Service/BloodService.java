package com.saveLife.Service;

import java.util.List;

import com.saveLife.Model.Blood;

public interface BloodService {
	List<Blood> fetchAll();
	int insert(Blood blood);
	int update(Blood blood);
	void delete(int bId);
	Blood fetchById(int bId);
	
}
