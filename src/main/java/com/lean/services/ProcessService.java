package com.lean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lean.models.Process;
import com.lean.repositories.ProcessRepository;

@Service
public class ProcessService {

	@Autowired
	private ProcessRepository processRepository;

	public List<Process> getAll() {
		return (List<Process>) processRepository.findAll();
	}

	public List<Process> addAll(List<Process> processes) {
		return (List<Process>) processRepository.saveAll(processes);
	}
}
