package com.notifier.traffic.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Crime {
	
	@Id
	@GeneratedValue
	private long id;
	private int violationCode;
	private String vehicleNumber;
	private LocalDate violationDate;
	private String paymentStatus;
	
	@CreationTimestamp
	private LocalDateTime createTimestamp;
	@UpdateTimestamp
	private LocalDateTime updateTimestamp;
	
	public Crime(int violationCode, String vehicleNumber, LocalDate violationDate, String paymentStatus) {
		super();
		this.violationCode = violationCode;
		this.vehicleNumber = vehicleNumber;
		this.violationDate = violationDate;
		this.paymentStatus = paymentStatus;
	}
}
