package com.qa.CVProjectTrainingManager.Tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.CVProjectTrainingManager.constants.Constants;
import com.qa.CVProjectTrainingManager.rest.Endpoint;
import com.qa.CVProjectTrainingManager.service.TrainingManagerService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TrainingManagerEndpointTest {
	
	@InjectMocks
	private Endpoint endpoint;

	@Mock
	private TrainingManagerService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void testGetAllCVs() {
		Mockito.when(service.getAllCVs()).thenReturn(Constants.MOCK_CVS);
		Assert.assertEquals(Constants.MOCK_CVS, endpoint.getAllCVS());
	}

}
