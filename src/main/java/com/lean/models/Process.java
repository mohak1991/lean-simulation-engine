package com.lean.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Process {
	@Id
	@GeneratedValue
	public Integer id;
	public String name;
	private Integer capacity;
}
