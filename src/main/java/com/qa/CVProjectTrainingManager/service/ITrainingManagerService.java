package com.qa.CVProjectTrainingManager.service;

import java.util.List;

import com.qa.CVProjectTrainingManager.persistence.domain.CV;
import com.qa.CVProjectTrainingManager.webservices.IConsumer;

public interface ITrainingManagerService {
	
	List<CV> getAllCVs();

}
