package com.lean.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lean.models.Process;
import com.lean.services.ProcessService;

@RestController
public class ProcessController {
	
	@Autowired
	private ProcessService processService;
	
	@GetMapping("/process")
	public List<Process> getAll() {
		return processService.getAll();
	}
	
	@PostMapping("/processes")
	public List<Process> addAll(@RequestBody List<Process> processes){
		return processService.addAll(processes);
	}
	
}
