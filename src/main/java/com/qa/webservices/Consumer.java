package com.qa.webservices;

import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.TrainingManager;


@Component
@CrossOrigin
public class Consumer implements IConsumer {
	
	private List<CV> listOfCVs;
	
	private List<TrainingManager> listOfTrainingManagers;
	
	@JmsListener(destination = "TrainingManagerGetAllCVQueue", containerFactory = "myFactory")
	public List<CV> recieveCVs(Iterable<CV> CVs) {
		for(CV cv: CVs) {
			listOfCVs.add(cv);
		}
		return listOfCVs;
	}

	@JmsListener(destination = "TrainingManagerGetAllTMQueue", containerFactory = "myFactory")
	public List<TrainingManager> getListOfTrainingManagers(Iterable<TrainingManager> trainingManagers) {
		for(TrainingManager trainingManager: trainingManagers) {
			listOfTrainingManagers.add(trainingManager);
		}
		return listOfTrainingManagers;
	}
	
	public List<CV> getListOfCVs() {
		return listOfCVs;
	}

	public List<TrainingManager> getListOfTrainingManagers() {
		return listOfTrainingManagers;
	}


}
