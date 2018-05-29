package com.lean.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lean.models.WorkItem;
import com.lean.services.WorkItemService;

@RestController
public class WorkItemController {
	
	@Autowired
	private WorkItemService workItemService;
	
	public WorkItem saveWorkItem(@RequestBody WorkItem workItem) {
		return workItemService.saveWorkItem(workItem);
	}
	
}
