package com.qa.CVProjectTrainingManager.webservices;

import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;


@Component
@CrossOrigin
public class Consumer implements IConsumer {
	
	private List<CV> listOfCVs;
	
	@JmsListener(destination = "TrainingManagerCVQueue", containerFactory = "myFactory")
	public List<CV> recieveCVs(Iterable<CV> CVs) {
		for(CV cv: CVs) {
			listOfCVs.add(cv);
		}
		return listOfCVs;
	}

	public Iterable<CV> getListOfCVs() {
		return listOfCVs;
	}

	public void setListOfCVs(Iterable<CV> listOfCVs) {
		this.listOfCVs = listOfCVs;
	}
	

}
