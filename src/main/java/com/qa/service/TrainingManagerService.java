package com.qa.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.constants.Constants;
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
	
	public String createTrainingManager(TrainingManager trainingManager) {
		if(usernameisunique(trainingManager)) {
			trainingManager.setID(generateUniqueID());
			producer.createTrainingManager(trainingManager);
		return Constants.TRAINING_MANAGER;
		} else {
			return Constants.USERNAME_NOT_UNIQUE;
		}
	}
	
	public Long generateUniqueID() {
		Long ID;
		if(getAllTrainingManagers().isEmpty()) {
			return ID=1L;
		} else {
			ID=getAllTrainingManagers().stream().mapToLong(e->e.getID()).max().getAsLong()+1L;
			return ID;
		}
	}

	public boolean usernameisunique(TrainingManager trainingManager) {
		if(findTrainingManagerByUsername(trainingManager.getUsername()).isPresent()) {
		return false;
		} else {
			return true;
		}
	}

	public Optional<TrainingManager> findTrainingManagerByUsername(String username) {
		producer.askForTrainingManagers();
		List<TrainingManager> trainingManagers=consumer.getListOfTrainingManagers();
		return trainingManagers.stream().filter(e->e.getUsername().equals(username)).findFirst();
	}
	
	public List<TrainingManager> getAllTrainingManagers() {
		producer.askForTrainingManagers();
		return consumer.getListOfTrainingManagers();
	}
	
	public TrainingManager updateTrainingManager(String username, TrainingManager newTrainingManager) {
		TrainingManager trainingManager = new TrainingManager();
		if(usernameisunique(newTrainingManager) || newTrainingManager.getUsername().equals(username)) {
		trainingManager.setID(findTrainingManagerByUsername(username).get().getID());		
		trainingManager.setFirstName(newTrainingManager.getFirstName());
		trainingManager.setLastName(newTrainingManager.getLastName());
		trainingManager.setUsername(newTrainingManager.getUsername());
		producer.sendTrainingManager(trainingManager);
		return trainingManager;
		} else  {
			trainingManager.setID(findTrainingManagerByUsername(username).get().getID());
			trainingManager.setFirstName(findTrainingManagerByUsername(username).get().getFirstName());
			trainingManager.setLastName(findTrainingManagerByUsername(username).get().getLastName());
			trainingManager.setUsername(username);
			return trainingManager;
		}
	}

	
	public void setProducer(IProducer producer) {
		this.producer = producer;
	}
	
	public void setConsumer(IConsumer consumer) {
		this.consumer = consumer;
	}





}
