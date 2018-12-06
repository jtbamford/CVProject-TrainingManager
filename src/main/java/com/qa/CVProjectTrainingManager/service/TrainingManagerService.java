package com.qa.CVProjectTrainingManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.CVProjectTrainingManager.persistence.domain.CV;
import com.qa.CVProjectTrainingManager.webservices.Consumer;
import com.qa.CVProjectTrainingManager.webservices.IConsumer;
import com.qa.CVProjectTrainingManager.webservices.IProducer;

@Service
public class TrainingManagerService implements ITrainingManagerService {
	
	@Autowired
	private IProducer producer;
	
	@Autowired
	private IConsumer consumer;

	public List<CV> getAllCVs() {
		producer.askForCVs();
		return (List<CV>) Consumer.getListOfCVs();
	}

	public void setProducer(IProducer producer) {
		this.producer = producer;
	}
	
	public void setConsumer(IConsumer consumer) {
		this.consumer = consumer;
	}


}
