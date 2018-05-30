package com.lean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lean.models.Process;
import com.lean.models.ProcessGroup;
import com.lean.models.WorkItem;
import com.lean.repositories.ProcessGroupRepository;
import com.lean.repositories.ProcessRepository;
import com.lean.repositories.WorkItemRepository;

@Service
public class ProcessGroupService {

	@Autowired
	private ProcessGroupRepository processGroupRepository;
	
	@Autowired
	private ProcessRepository processRepository;
	
	@Autowired
	private WorkItemRepository workItemRepository;
	
	public ProcessGroup addProcessGroup(ProcessGroup processGroup) {
		return processGroupRepository.save(processGroup);
	}

	public ProcessGroup get() {
		List<ProcessGroup> processGroups = (List<ProcessGroup>) processGroupRepository.findAll();
		if(processGroups.size()>0) {
			return processGroups.get(0);
		}
		else {
			return null;
		}
		
	}

	public ProcessGroup addProcessInGroup(Integer id, Process process) {
		if(processGroupRepository.existsById(id)) {
			Process newProcess = processRepository.save(process);
			ProcessGroup existingProcessGroup = processGroupRepository.findById(id).get();
			List<Process> existingProcesses = existingProcessGroup.getProcesses();
			existingProcesses.add(newProcess);
			return processGroupRepository.save(existingProcessGroup);
		}
		return null;
	}

	public ProcessGroup addProcessesInGroup(Integer id, List<Process> processes) {
		if(processGroupRepository.existsById(id)) {
			List<Process> newProcesses = (List<Process>) processRepository.saveAll(processes);
			ProcessGroup existingProcessGroup = processGroupRepository.findById(id).get();
			List<Process> existingProcesses = existingProcessGroup.getProcesses();
			existingProcesses.addAll(newProcesses);
			return processGroupRepository.save(existingProcessGroup);
		}
		return null;
	}

	public ProcessGroup addWorkItemInGroup(Integer id, WorkItem workItem) {
		if(processGroupRepository.existsById(id)) {
			WorkItem newWorkItem = workItemRepository.save(workItem);
			ProcessGroup existingProcessGroup = processGroupRepository.findById(id).get();
			List<WorkItem> existingWorkItems = existingProcessGroup.getBacklog();
			existingWorkItems.add(newWorkItem);
			return processGroupRepository.save(existingProcessGroup);
		}
		return null;
	}

	public ProcessGroup addWorkItemsInGroup(Integer id, List<WorkItem> workItems) {
		if(processGroupRepository.existsById(id)) {
			List<WorkItem> newWorkItems = (List<WorkItem>) workItemRepository.saveAll(workItems);
			ProcessGroup existingProcessGroup = processGroupRepository.findById(id).get();
			List<WorkItem> existingWorkItems = existingProcessGroup.getBacklog();
			existingWorkItems.addAll(newWorkItems);
			return processGroupRepository.save(existingProcessGroup);
		}
		return null;
	}
}
