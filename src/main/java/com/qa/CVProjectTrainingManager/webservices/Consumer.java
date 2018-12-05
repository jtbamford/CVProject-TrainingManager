package com.qa.CVProjectTrainingManager.webservices;

import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.google.common.collect.Lists;

@Component
@CrossOrigin
public class Consumer implements IConsumer {
	
	private Iterable<CV> listOfCVs;
	
	@JmsListener(destination = "TrainingManagerCVQueue", containerFactory = "myFactory")
	public Iterable<CV> recieveCVs(Iterable<CV> CVs) {
		listOfCVs=CVs;
		return CVs;
	}

	public Iterable<CV> getListOfCVs() {
		return listOfCVs;
	}

	public void setListOfCVs(Iterable<CV> listOfCVs) {
		this.listOfCVs = listOfCVs;
	}
	

}
