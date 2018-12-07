package com.qa.service;

import java.util.List;

import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.TrainingManager;
import com.qa.webservices.IConsumer;

public interface ITrainingManagerService {
	
	List<CV> getAllCVs();

	TrainingManager createTrainingManager(TrainingManager trainingManager);
	
	TrainingManager findTrainingManagerByUsername(String username);
	
	List<TrainingManager> getAllTrainingManagers();

}
