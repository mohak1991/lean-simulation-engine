package com.lean.models;

import java.util.List;
import java.util.ListIterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
	private List<WorkItem> completed;
	@OneToMany
	private List<Process> processes;
	
	
	public ProcessGroup executeIteration() {
		
		Process completedProcess = new Process();
		completedProcess.setName("Completed");
		completedProcess.setWorkItems(this.completed);
		
		processes.add(completedProcess);
		
		ListIterator<Process> iteratorProcesses = processes.listIterator(processes.size()-1);
		Process nextProcess = completedProcess;
		while(iteratorProcesses.hasPrevious()) {
			Process currentProcess = iteratorProcesses.previous();
			System.out.println("============");
			System.out.println(currentProcess);
			for(int i=0;i<currentProcess.getCapacity();i++) {
				if(currentProcess.getWorkItems().size() > 0) {
					nextProcess.getWorkItems().add(currentProcess.getWorkItems().remove(0));
				}
			}
			System.out.println(nextProcess);
			System.out.println("============");
			
			
			nextProcess = currentProcess;
		}
		
		this.completed = completedProcess.getWorkItems();
		processes.remove(completedProcess);
		return this;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
