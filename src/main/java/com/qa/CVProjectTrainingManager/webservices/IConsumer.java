package com.qa.CVProjectTrainingManager.webservices;

import com.qa.CVProjectTrainingManager.service.CV;

public interface IConsumer {

	Iterable<CV> recieveCVs(Iterable<CV> CVs);

}
