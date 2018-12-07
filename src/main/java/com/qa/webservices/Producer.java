package com.qa.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.qa.constants.Constants;
import com.qa.persistence.domain.TrainingManager;

@RestController
@CrossOrigin
public class Producer implements IProducer {
	
	 @Autowired
	  private JmsTemplate jmsTemplate;
	
	public String askForCVs() {
		String get="get";
		jmsTemplate.convertAndSend("TrainingManagerGetCVQueue",get);
		return Constants.QUEUE_MESSAGE;
	}
	
	public String createTrainingManager(TrainingManager trainingManager) {
		jmsTemplate.convertAndSend("CreateTrainingManagerQueue",trainingManager);
		return Constants.QUEUE_MESSAGE;
	}


}
