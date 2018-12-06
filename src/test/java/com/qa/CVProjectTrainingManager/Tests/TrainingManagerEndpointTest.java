package com.qa.CVProjectTrainingManager.Tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.CVProjectTrainingManager.persistence.domain.CV;
import com.qa.CVProjectTrainingManager.rest.Endpoint;
import com.qa.CVProjectTrainingManager.service.TrainingManagerService;


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
		CV cv = new CV();
		List<CV >listCV=new ArrayList<CV>();
		listCV.add(cv);
		Mockito.when(service.getAllCVs()).thenReturn(listCV);
		Assert.assertEquals(listCV, endpoint.getAllCVs());
	}

}
