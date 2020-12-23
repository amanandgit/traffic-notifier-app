package com.notifier.traffic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notifier.traffic.service.SearchDefaultersServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.notifier.traffic.service.NotificationService;

/** This controller will be called as a API to send Notification to traffic defaulter.
 * @author Aman Anand
 *
 */
@Slf4j
@RequestMapping("/api")
@RestController
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private SearchDefaultersServiceImpl defaultersService;
	
	@GetMapping(value = "/sendNotification")
	public List<String> sendNotification() throws Exception {
		log.info("NotificationController.sendNotification >> inside controller ");
		return notificationService.notifyDefaulters(defaultersService.getDefaultersListForLastWeek());
	}
	
	@GetMapping(value = "/notifyGrthSeventy")
	public List<String> notifyGrthSeventy() throws Exception {
		log.info("NotificationController.notifyGrthSeventy >> inside controller ");
		
		return notificationService.notifyVehiclesGreaterthanSeventy(defaultersService.getDefaultersListForVehiclesGreaterthanSeventy());
	}

}
