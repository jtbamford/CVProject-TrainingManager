package com.qa.CVProjectTrainingManager.Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.constants.Constants;
import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.TrainingManager;
import com.qa.service.TrainingManagerService;
import com.qa.webservices.Consumer;
import com.qa.webservices.Producer;

@RunWith(MockitoJUnitRunner.class)
public class TrainingManagerServiceTest {

	@InjectMocks
	private TrainingManagerService service;
	
	@Mock
	private Consumer consumer;
	
	@Mock
	private Producer producer;

	@Before
	public void setup() {
		service.setConsumer(consumer);
		service.setProducer(producer);
	}

	@Test
	public void testGetAllCVs() {
		CV cv = new CV();
		List<CV >listCV=new ArrayList<CV>();
		listCV.add(cv);
		Mockito.when(producer.askForCVs()).thenReturn(Constants.QUEUE_MESSAGE);
		Mockito.when(consumer.getListOfCVs()).thenReturn(listCV);
		Assert.assertEquals(listCV, service.getAllCVs());
	}
	
	@Test
	public void testCreateTrainingManager() {
		TrainingManager mockTrainingManager = new TrainingManager();
		mockTrainingManager.setUsername("user");
		List<TrainingManager> listTrainingManagers = new ArrayList<TrainingManager>();
		Mockito.when(producer.askForTrainingManagers()).thenReturn(Constants.QUEUE_MESSAGE);
		Mockito.when(consumer.getListOfTrainingManagers()).thenReturn(listTrainingManagers);		
		Mockito.when(producer.createTrainingManager(mockTrainingManager)).thenReturn(Constants.QUEUE_MESSAGE);
		Assert.assertEquals(Constants.TRAINING_MANAGER, service.createTrainingManager(mockTrainingManager));
	}
	
	@Test
	public void testFindTrainingManager() {
		TrainingManager mockTrainingManager = new TrainingManager();
		mockTrainingManager.setUsername("user");
		List<TrainingManager> listTrainingManagers = new ArrayList<TrainingManager>();
		listTrainingManagers.add(mockTrainingManager);
		Mockito.when(producer.askForTrainingManagers()).thenReturn(Constants.QUEUE_MESSAGE);
		Mockito.when(consumer.getListOfTrainingManagers()).thenReturn(listTrainingManagers);
		Assert.assertEquals(mockTrainingManager, service.findTrainingManagerByUsername(mockTrainingManager.getUsername()).get());
	}
	
	@Test
	public void testGetAllTrainingManagers() {
		TrainingManager mockTrainingManager = new TrainingManager();
		List<TrainingManager> listTrainingManagers = new ArrayList<TrainingManager>();
		listTrainingManagers.add(mockTrainingManager);
		Mockito.when(producer.askForTrainingManagers()).thenReturn(Constants.QUEUE_MESSAGE);
		Mockito.when(consumer.getListOfTrainingManagers()).thenReturn(listTrainingManagers);
		Assert.assertEquals(listTrainingManagers, service.getAllTrainingManagers());
	}
	
	@Test
	public void testUpdateTrainingManager() {
		TrainingManager mockTrainingManager = new TrainingManager();
		mockTrainingManager.setUsername("user");
		mockTrainingManager.setID(1L);
		List<TrainingManager> listTrainingManagers = new ArrayList<TrainingManager>();
		listTrainingManagers.add(mockTrainingManager);
		TrainingManager newTrainingManager = new TrainingManager();
		newTrainingManager.setFirstName("1st");
		newTrainingManager.setLastName("end");
		newTrainingManager.setUsername("name");
		Mockito.when(producer.askForTrainingManagers()).thenReturn(Constants.QUEUE_MESSAGE);
		Mockito.when(consumer.getListOfTrainingManagers()).thenReturn(listTrainingManagers);
		Assert.assertEquals(newTrainingManager.getFirstName(), service.updateTrainingManager(mockTrainingManager.getUsername(),newTrainingManager).getFirstName());
		Assert.assertEquals(newTrainingManager.getLastName(), service.updateTrainingManager(mockTrainingManager.getUsername(),newTrainingManager).getLastName());
		Assert.assertEquals(newTrainingManager.getUsername(), service.updateTrainingManager(mockTrainingManager.getUsername(),newTrainingManager).getUsername());
		Assert.assertEquals(mockTrainingManager.getID(), service.updateTrainingManager(mockTrainingManager.getUsername(),newTrainingManager).getID());
	}
	
	@Test
	public void testUpdateTrainingManagerUsernameNotUnique() {
		TrainingManager mockTrainingManager = new TrainingManager();
		TrainingManager sameUsernameTrainingManager = new TrainingManager();
		mockTrainingManager.setUsername("user");
		mockTrainingManager.setID(1L);
		sameUsernameTrainingManager.setUsername("name");
		sameUsernameTrainingManager.setID(2L);
		List<TrainingManager> listTrainingManagers = new ArrayList<TrainingManager>();
		listTrainingManagers.add(mockTrainingManager);
		listTrainingManagers.add(sameUsernameTrainingManager);
		TrainingManager newTrainingManager = new TrainingManager();
		newTrainingManager.setFirstName("1st");
		newTrainingManager.setLastName("end");
		newTrainingManager.setUsername("name");
		Mockito.when(producer.askForTrainingManagers()).thenReturn(Constants.QUEUE_MESSAGE);
		Mockito.when(consumer.getListOfTrainingManagers()).thenReturn(listTrainingManagers);
		Assert.assertEquals(mockTrainingManager.getFirstName(), service.updateTrainingManager(mockTrainingManager.getUsername(),newTrainingManager).getFirstName());
		Assert.assertEquals(mockTrainingManager.getLastName(), service.updateTrainingManager(mockTrainingManager.getUsername(),newTrainingManager).getLastName());
		Assert.assertEquals(mockTrainingManager.getUsername(), service.updateTrainingManager(mockTrainingManager.getUsername(),newTrainingManager).getUsername());
		Assert.assertEquals(mockTrainingManager.getID(), service.updateTrainingManager(mockTrainingManager.getUsername(),newTrainingManager).getID());
	}
	
	
	@Test
	public void testCreateTrainingManagerUsernameNotUnique() {
		TrainingManager newTrainingManager = new TrainingManager();
		newTrainingManager.setUsername("user");
		TrainingManager otherTrainingManager = new TrainingManager();
		otherTrainingManager.setUsername("user");
		List<TrainingManager> listTrainingManagers = new ArrayList<TrainingManager>();
		listTrainingManagers.add(otherTrainingManager);
		Mockito.when(producer.askForTrainingManagers()).thenReturn(Constants.QUEUE_MESSAGE);
		Mockito.when(consumer.getListOfTrainingManagers()).thenReturn(listTrainingManagers);
		Assert.assertEquals(Constants.USERNAME_NOT_UNIQUE, service.createTrainingManager(newTrainingManager));
	}
	
	@Test
	public void testGenerateUniqueID() {
		TrainingManager mockTrainingManager = new TrainingManager();
		mockTrainingManager.setUsername("user");
		TrainingManager otherTrainingManager = new TrainingManager();
		otherTrainingManager.setUsername("user2");
		List<TrainingManager> listTrainingManagers = new ArrayList<TrainingManager>();
		mockTrainingManager.setID(service.generateUniqueID());
		Assert.assertEquals(Long.valueOf(1), mockTrainingManager.getID());
		listTrainingManagers.add(mockTrainingManager);
		Mockito.when(consumer.getListOfTrainingManagers()).thenReturn(listTrainingManagers);
		otherTrainingManager.setID(service.generateUniqueID());
		Assert.assertEquals(Long.valueOf(2), otherTrainingManager.getID());
	}
	
	@Test
	public void testGenerateUniqueIDWithDeleteLast() {
		List<TrainingManager> listTrainingManagers = new ArrayList<TrainingManager>();
		Mockito.when(consumer.getListOfTrainingManagers()).thenReturn(listTrainingManagers);
		TrainingManager mockTrainingManager = new TrainingManager();
		TrainingManager otherTrainingManager = new TrainingManager();
		TrainingManager nextTrainingManager = new TrainingManager();
		mockTrainingManager.setUsername("user");
		otherTrainingManager.setUsername("user2");
		nextTrainingManager.setUsername("user3");
		mockTrainingManager.setID(service.generateUniqueID());
		Assert.assertEquals(Long.valueOf(1), mockTrainingManager.getID());
		listTrainingManagers.add(mockTrainingManager);
		otherTrainingManager.setID(service.generateUniqueID());
		Assert.assertEquals(Long.valueOf(2), otherTrainingManager.getID());
		listTrainingManagers.remove(otherTrainingManager);
		nextTrainingManager.setID(service.generateUniqueID());
		Assert.assertEquals(Long.valueOf(2), nextTrainingManager.getID());
	}
	
	@Test
	public void testGenerateUniqueIDWithDeleteFirst() {
		List<TrainingManager> listTrainingManagers = new ArrayList<TrainingManager>();
		Mockito.when(consumer.getListOfTrainingManagers()).thenReturn(listTrainingManagers);
		TrainingManager mockTrainingManager = new TrainingManager();
		TrainingManager otherTrainingManager = new TrainingManager();
		TrainingManager nextTrainingManager = new TrainingManager();
		mockTrainingManager.setUsername("user");
		otherTrainingManager.setUsername("user2");
		nextTrainingManager.setUsername("user3");
		mockTrainingManager.setID(service.generateUniqueID());
		Assert.assertEquals(Long.valueOf(1), mockTrainingManager.getID());
		listTrainingManagers.add(mockTrainingManager);
		otherTrainingManager.setID(service.generateUniqueID());
		Assert.assertEquals(Long.valueOf(2), otherTrainingManager.getID());
		listTrainingManagers.add(otherTrainingManager);
		listTrainingManagers.remove(mockTrainingManager);
		nextTrainingManager.setID(service.generateUniqueID());
		Assert.assertEquals(Long.valueOf(3), nextTrainingManager.getID());
	}
	
	@Test
	public void testDeleteTrainingManager() {
		TrainingManager mockTrainingManager = new TrainingManager();
		mockTrainingManager.setUsername("user");
		List<TrainingManager> listTrainingManagers = new ArrayList<TrainingManager>();
		listTrainingManagers.add(mockTrainingManager);
		Mockito.when(consumer.getListOfTrainingManagers()).thenReturn(listTrainingManagers);
		Assert.assertEquals(Constants.MANAGER_DELETED, service.deleteTrainingManager("user"));
	}


}
