package com.lean.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lean.models.WorkItem;
import com.lean.services.WorkItemService;

@RestController
public class WorkItemController {
	
	@Autowired
	private WorkItemService workItemService;
	
	@GetMapping("/workItem")
	public List<WorkItem> getWorkItems(){
		return workItemService.getAll();
	}
	
	@PostMapping("/workItem")
	public WorkItem saveWorkItem(@RequestBody WorkItem workItem) {
		return workItemService.saveWorkItem(workItem);
	}
	
}
