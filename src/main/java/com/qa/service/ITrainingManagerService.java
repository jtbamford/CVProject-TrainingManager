package com.qa.service;

import java.util.List;
import java.util.Optional;

import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.TrainingManager;
import com.qa.webservices.IConsumer;

public interface ITrainingManagerService {
	
	List<CV> getAllCVs();

	String createTrainingManager(TrainingManager trainingManager);
	
	Optional<TrainingManager> findTrainingManagerByUsername(String username);
	
	List<TrainingManager> getAllTrainingManagers();
	
	TrainingManager updateTrainingManager(String username, TrainingManager newTrainingManager);
	
	boolean usernameisunique(TrainingManager trainingManager);

}
