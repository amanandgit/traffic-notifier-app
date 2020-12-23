package com.notifier.traffic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
	
	@Id
	private String vehicleNumber;
	private String state;
	private String type;
	private String name;
	private String ownerName;
	private String emailId;
}
