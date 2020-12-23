package com.notifier.traffic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class TrafficFineNotifierAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficFineNotifierAppApplication.class, args);
		System.out.println("****************Traffic Notifier App Started***************");
		log.info("****************Traffic Notifier App Started***************");
	}
}
