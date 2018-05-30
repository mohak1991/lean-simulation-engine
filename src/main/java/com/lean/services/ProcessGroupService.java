package com.lean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lean.models.ProcessGroup;
import com.lean.repositories.ProcessGroupRepository;

@Service
public class ProcessGroupService {

	@Autowired
	private ProcessGroupRepository processGroupRepository;
	
	public ProcessGroup addProcessGroup(ProcessGroup processGroup) {
		return processGroupRepository.save(processGroup);
	}

	public ProcessGroup get() {
		List<ProcessGroup> processGroups = (List<ProcessGroup>) processGroupRepository.findAll();
		return processGroups.get(0);
	}

}
