package com.qa.CVProjectTrainingManager.webservices;

import java.util.List;

import com.qa.CVProjectTrainingManager.service.CV;

public interface IConsumer {

	List<CV> recieveCVs(Iterable<CV> CVs);

}
