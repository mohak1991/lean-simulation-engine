package com.lean.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lean.models.ProcessGroup;
import com.lean.models.WorkItem;
import com.lean.models.Process;
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
	
	@PostMapping("/processGroup/{id}/process")
	public ProcessGroup addProcessInGroup(@PathVariable Integer id, @RequestBody Process process) {
		return processGroupService.addProcessInGroup(id,process);
	}
	
	@PostMapping("/processGroup/{id}/processes")
	public ProcessGroup addProcessesInGroup(@PathVariable Integer id, @RequestBody List<Process> processes) {
		return processGroupService.addProcessesInGroup(id,processes);
	}
	
	@PostMapping("/processGroup/{id}/workItem")
	public ProcessGroup addWorkItemInGroup(@PathVariable Integer id, @RequestBody WorkItem workItem) {
		return processGroupService.addWorkItemInGroup(id,workItem);
	}
	
	@PostMapping("/processGroup/{id}/workItems")
	public ProcessGroup addWorkItemsInGroup(@PathVariable Integer id, @RequestBody List<WorkItem> workItems) {
		return processGroupService.addWorkItemsInGroup(id,workItems);
	}
	
	@PostMapping("processGroup/{id}/execute")
	public void execute(@PathVariable Integer id) {
		processGroupService.execute(id);
	}
}

