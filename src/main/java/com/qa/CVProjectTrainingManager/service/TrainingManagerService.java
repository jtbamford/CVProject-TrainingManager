package com.qa.CVProjectTrainingManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.CVProjectTrainingManager.webservices.Consumer;
import com.qa.CVProjectTrainingManager.webservices.IConsumer;
import com.qa.CVProjectTrainingManager.webservices.IProducer;

@Service
public class TrainingManagerService implements ITrainingManagerService {
	
	@Autowired
	private IProducer producer;
	
	@Autowired
	private IConsumer consumer;

	public Iterable<CV> getAllCVs() {
		producer.askForCVs();
		return Consumer.getListOfCVs();
	}

	public void setProducer(IProducer producer) {
		this.producer = producer;
	}
	
	public void setConsumer(IConsumer consumer) {
		this.consumer = consumer;
	}


}
