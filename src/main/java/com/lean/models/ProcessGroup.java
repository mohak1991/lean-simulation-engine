package com.lean.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
}
