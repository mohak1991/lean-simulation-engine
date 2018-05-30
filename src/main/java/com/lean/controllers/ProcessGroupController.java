package com.lean.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lean.models.ProcessGroup;
import com.lean.services.ProcessGroupService;

@RestController
public class ProcessGroupController {

	@Autowired
	private ProcessGroupService processGroupService;
	
	@PostMapping("/processGroup")
	public ProcessGroup addProcessGroup(@RequestBody ProcessGroup processGroup) {
		return processGroupService.addProcessGroup(processGroup);
	}
	
	@GetMapping("/processGroup")
	public ProcessGroup get() {
		return processGroupService.get();
	}
}

