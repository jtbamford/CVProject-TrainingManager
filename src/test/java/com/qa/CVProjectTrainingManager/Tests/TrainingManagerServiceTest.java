package com.qa.CVProjectTrainingManager.Tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.qa.CVProjectTrainingManager.constants.Constants;
import com.qa.CVProjectTrainingManager.rest.Endpoint;
import com.qa.CVProjectTrainingManager.service.TrainingManagerService;
import com.qa.CVProjectTrainingManager.webservices.Consumer;
import com.qa.CVProjectTrainingManager.webservices.IProducer;

import junit.framework.Assert;

public class TrainingManagerServiceTest {

	@InjectMocks
	private TrainingManagerService service;
	
	@Mock
	private IProducer producer;

	@Before
	public void setup() {
		service.setProducer(producer);
	}

	@Test
	public void testGetAllCVs() {
		Iterable<CV> CVs=
		Mockito.when(Consumer.getListOfCVs()).thenReturn(Constants.MOCK_CVS);
		Assert.assertEquals(Constants.MOCK_CVS, service.getAllCVs());
	}


}
