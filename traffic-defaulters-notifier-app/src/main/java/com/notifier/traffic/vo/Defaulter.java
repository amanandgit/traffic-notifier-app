package com.notifier.traffic.vo;

import java.io.Serializable;

import lombok.Data;

/** This a VO class to get the values for the query from Defaultersrepository.
 * @author Aman Anand
 *
 */
@Data
public class Defaulter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String vehicleNumber;
	private int violationCode;
	private String emailId;
	private String ownerName;
	private String violationDate;
	private int fine;
	private String description;
}
