package com.lean.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Process {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer capacity;
	@OneToMany
	private List<WorkItem> workItems;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
