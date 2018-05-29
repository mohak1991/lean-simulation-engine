package com.lean.services;

import org.springframework.stereotype.Service;

import com.lean.models.WorkItem;

@Service
public class WorkItemService {

	//@Autowired
	//private WorkItemRepository workItemRepository;
	
	public WorkItem saveWorkItem(WorkItem workItem) {
		return workItem;
	}
}

