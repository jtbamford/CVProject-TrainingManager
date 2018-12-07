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
		// add method giving error if username not unique
		producer.createTrainingManager(trainingManager);
		return trainingManager;
	}

	public TrainingManager findTrainingManagerByUsername(String username) {
		producer.askForTrainingManagers();
		List<TrainingManager> trainingManagers=consumer.getListOfTrainingManagers();
		return trainingManagers.stream().filter(e->e.getUsername().equals(username)).findFirst().get();
	}
	
	public List<TrainingManager> getAllTrainingManagers() {
		producer.askForTrainingManagers();
		return consumer.getListOfTrainingManagers();
	}
	
	public TrainingManager updateTrainingManager(String username, TrainingManager newTrainingManager) {
		// add method giving error if new username not unique
		TrainingManager trainingManager = new TrainingManager();
		trainingManager.setID(findTrainingManagerByUsername(username).getID());		
		trainingManager.setFirstName(newTrainingManager.getFirstName());
		trainingManager.setLastName(newTrainingManager.getLastName());
		trainingManager.setUsername(newTrainingManager.getUsername());
		producer.sendTrainingManager(trainingManager);
		return trainingManager;
	}

	
	public void setProducer(IProducer producer) {
		this.producer = producer;
	}
	
	public void setConsumer(IConsumer consumer) {
		this.consumer = consumer;
	}





}
