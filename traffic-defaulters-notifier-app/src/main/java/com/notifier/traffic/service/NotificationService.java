package com.notifier.traffic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.notifier.traffic.vo.Defaulter;

/** This is a service class to call the email service to send notification.
 * @author Aman Anand
 *
 */
@Component
public class NotificationService {
	
	@Autowired
	private EmailService emailService;

	public List<String> notifyDefaulters(List<Defaulter> defaulters) {
		
		List<String> defaultersList = new ArrayList<>();
		defaultersList.add("Email Notification Sent to below Persons: ");
		for(Defaulter defaulter : defaulters) {
			emailService.sendEmailReport(defaulter);
			defaultersList.add("Name: "+defaulter.getOwnerName()+" - Vehicle: "+defaulter.getVehicleNumber());
		}
		return defaultersList;
	}

	public List<String> notifyVehiclesGreaterthanSeventy(List<Defaulter> defaultersListForVehiclesGreaterthanSeventy) {
		List<String> defaultersList = new ArrayList<>();
		defaultersList.add("Email Notification Sent to below Persons: ");
		
		for(Defaulter defaulter : defaultersListForVehiclesGreaterthanSeventy) {
			
			int vnum = Integer.parseInt(defaulter.getVehicleNumber().subSequence(5, 9).toString());
				if(vnum > 2370) {
					//emailService.sendEmailReport(defaulter);
					defaultersList.add("Name: "+defaulter.getOwnerName()+" - Vehicle: "+defaulter.getVehicleNumber());
				}
		}
		
		
		return defaultersList;
	}
}
