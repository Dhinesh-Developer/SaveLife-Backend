package com.saveLife.Service;

import java.util.List;

import com.saveLife.Model.Emergency;

public interface EmergencyService {
	List<Emergency> fetchAll();
	int update (Emergency emergency);
	int delete(int eId);
	Emergency fetchById(int eId);
	int insert(Emergency emergency);
}
