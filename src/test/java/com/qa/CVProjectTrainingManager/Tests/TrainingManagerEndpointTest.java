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

import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.TrainingManager;
import com.qa.rest.Endpoint;
import com.qa.service.TrainingManagerService;


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
	
	@Test
	public void testCreateTrainingManager() {
		TrainingManager mockTrainingManager = new TrainingManager();
		Mockito.when(service.createTrainingManager(mockTrainingManager)).thenReturn(mockTrainingManager);
		Assert.assertEquals(mockTrainingManager, endpoint.createTrainingManager(mockTrainingManager));
	}
	
	@Test
	public void testFindTrainingManager() {
		TrainingManager mockTrainingManager = new TrainingManager();
		Mockito.when(service.findTrainingManagerByUsername(mockTrainingManager.getUsername())).thenReturn(mockTrainingManager);
		Assert.assertEquals(mockTrainingManager, endpoint.findTrainingManagerByUsername(mockTrainingManager.getUsername()));
	}

}
