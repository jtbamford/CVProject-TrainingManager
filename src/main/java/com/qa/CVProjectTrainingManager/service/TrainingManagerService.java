package com.qa.CVProjectTrainingManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.CVProjectTrainingManager.rest.CV;
import com.qa.CVProjectTrainingManager.webservices.IConsumer;

@Service
public class TrainingManagerService implements ITrainingManagerService {
	
	@Autowired
	private IConsumer consumer;

	public Iterable<CV> getAllCVs() {
		return consumer.getAllCVs();
	}

}
