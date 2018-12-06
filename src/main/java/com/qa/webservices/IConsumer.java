package com.qa.webservices;

import java.util.List;

import com.qa.persistence.domain.CV;

public interface IConsumer {

	List<CV> recieveCVs(Iterable<CV> CVs);
	
	List<CV> getListOfCVs();

}
