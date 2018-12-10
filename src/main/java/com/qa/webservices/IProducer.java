package com.qa.webservices;

import java.util.Optional;

import com.qa.persistence.domain.TrainingManager;

public interface IProducer {

	String askForCVs();
	
	String createTrainingManager(TrainingManager trainingManager);

	String askForTrainingManagers();

	String sendTrainingManager(TrainingManager trainingManager);

	String deleteTrainingManager(Optional<TrainingManager> manager);

}
