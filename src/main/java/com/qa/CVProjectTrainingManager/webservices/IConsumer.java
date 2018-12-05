package com.qa.CVProjectTrainingManager.webservices;

import com.qa.CVProjectTrainingManager.service.CV;

public interface IConsumer {

	Iterable<CV> getAllCVs();

}
