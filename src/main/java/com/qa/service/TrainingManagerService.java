package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.TrainingManager;
import com.qa.webservices.IConsumer;
import com.qa.webservices.IProducer;

@Service
public class TrainingManagerService implements ITrainingManagerService {
	
	@Autowired
	private IProducer producer;
	
	@Autowired
	private IConsumer consumer;

	public List<CV> getAllCVs() {
		producer.askForCVs();
		return (List<CV>) consumer.getListOfCVs();
	}
	
	public TrainingManager createTrainingManager(TrainingManager trainingManager) {
		producer.createTrainingManager(trainingManager);
		return trainingManager;
	}

	public TrainingManager findTrainingManagerByUsername(String username) {
		producer.askForTrainingManagers();
		List<TrainingManager> trainingManagers=consumer.getListOfTrainingManagers();
		return trainingManagers.stream().filter(e->e.getUsername().equals(username)).findFirst().get();
	}

	
	public void setProducer(IProducer producer) {
		this.producer = producer;
	}
	
	public void setConsumer(IConsumer consumer) {
		this.consumer = consumer;
	}

}
