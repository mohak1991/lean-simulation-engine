package com.lean.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.lean.models.Process;

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
	@ManyToOne
	private Process process;
}
