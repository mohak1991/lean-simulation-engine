package com.lean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lean.models.WorkItem;
import com.lean.repositories.WorkItemRepository;

@Service
public class WorkItemService {

	@Autowired
	private WorkItemRepository workItemRepository;
	
	public WorkItem saveWorkItem(WorkItem workItem) {
		return workItemRepository.save(workItem);
	}

	public List<WorkItem> getAll() {
		return (List<WorkItem>) workItemRepository.findAll();
	}

	public List<WorkItem> saveWorkItems(List<WorkItem> workItems) {
		return (List<WorkItem>) workItemRepository.saveAll(workItems);
	}
}

