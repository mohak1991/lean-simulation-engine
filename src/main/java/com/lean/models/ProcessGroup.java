package com.lean.models;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.lean.models.Process;

@Entity
@lombok.Setter
@lombok.Getter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class ProcessGroup {
	@Id
	@GeneratedValue
	private Integer id;
	@OneToMany
	private List<WorkItem> backlog;
	@OneToMany
	private List<WorkItem> completed;
	@OneToMany
	private List<Process> processes;
	
	
	public ProcessGroup executeIteration() {
		Iterator<Process> iteratorProcesses = processes.iterator();
		int processIteratorIndex = 0;
		while(iteratorProcesses.hasNext()) {
			Process currentProcess = iteratorProcesses.next();
			
			
			if(processIteratorIndex == 0) {
				for(int i=0;i<currentProcess.getCapacity();i++) {
					if(backlog.size()>0) {
						currentProcess.getWorkItems().add(backlog.remove(0));
					}
				}
			}
			else {
				Process lastProcess = processes.get(processIteratorIndex - 1);
				for(int i=0;i<currentProcess.getCapacity();i++) {
					if(lastProcess.getWorkItems().size()>0) {
						currentProcess.getWorkItems().add(lastProcess.getWorkItems().remove(0));
					}
				}
			}
			
			processIteratorIndex++;
		}
		
		return this;
	}
}
