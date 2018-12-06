package com.qa.CVProjectTrainingManager.service;

import java.util.List;

import com.qa.CVProjectTrainingManager.persistence.domain.CV;

public interface ITrainingManagerService {
	
	List<CV> getAllCVs();

}
