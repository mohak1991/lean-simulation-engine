package com.lean.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
public class WorkItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
