package com.qa.CVProjectTrainingManager.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.CVProjectTrainingManager.service.TrainingManagerService;

@RequestMapping("${base_endpoint}")
@RestController
@CrossOrigin
public class Endpoint {
	
	@Autowired
	private TrainingManagerService service;
	
	@GetMapping("${getall_endpoint}")
	public List<CV> getAllCVs() {
		return service.getAllCVs();
	}
	
	public void setService(TrainingManagerService service) {
		this.service = service;
	}

	public TrainingManagerService getService() {
		return service;
	}

}
