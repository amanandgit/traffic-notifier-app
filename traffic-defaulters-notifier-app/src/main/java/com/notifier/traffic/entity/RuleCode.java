package com.notifier.traffic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RuleCode {
	
	@Id
	@GeneratedValue
	private long id;
	private int violationCode;
	private int fine;
	private String description;
	
	public RuleCode(int violationCode, int fine, String description) {
		super();
		this.violationCode = violationCode;
		this.fine = fine;
		this.description = description;
	}
}
