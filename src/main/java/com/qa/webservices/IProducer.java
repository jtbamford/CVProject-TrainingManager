package com.qa.webservices;

import com.qa.persistence.domain.TrainingManager;

public interface IProducer {

	String askForCVs();
	
	String createTrainingManager(TrainingManager trainingManager);

	String askForTrainingManagers();

}
