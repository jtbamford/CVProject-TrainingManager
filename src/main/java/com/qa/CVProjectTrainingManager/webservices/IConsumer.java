package com.qa.CVProjectTrainingManager.webservices;

import java.util.List;

import com.qa.CVProjectTrainingManager.persistence.domain.CV;

public interface IConsumer {

	List<CV> recieveCVs(Iterable<CV> CVs);
	
	List<CV> getListOfCVs();

}
