package com.qa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.TrainingManager;
import com.qa.service.ITrainingManagerService;

@RequestMapping("${base_endpoint}")
@RestController
@CrossOrigin
public class Endpoint {
	
	@Autowired
	private ITrainingManagerService service;
	
	@GetMapping("${getall_cvs_endpoint}")
	public List<CV> getAllCVs() {
		return service.getAllCVs();
	}
	
	@PostMapping("${create_endpoint}")
	public TrainingManager createTrainingManager(TrainingManager trainingManager) {
		return service.createTrainingManager(trainingManager);
	}
	
	@GetMapping("${get_manager_endpoint}")
	public TrainingManager findTrainingManagerByUsername(@RequestBody String username) {
		return service.findTrainingManagerByUsername(username);
	}
	
	@GetMapping("${getall_managers_endpoint}")
	public List<TrainingManager> getAllTrainingManagers() {
		return service.getAllTrainingManagers();
	}


	
	public void setService(ITrainingManagerService service) {
		this.service = service;
	}

	public ITrainingManagerService getService() {
		return service;
	}



}
