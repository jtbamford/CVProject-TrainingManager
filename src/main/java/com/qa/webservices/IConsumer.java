package com.qa.webservices;

import java.util.List;

import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.TrainingManager;

public interface IConsumer {

	List<CV> recieveCVs(Iterable<CV> CVs);
	
	List<CV> getListOfCVs();

	List<TrainingManager> getListOfTrainingManagers();

}
