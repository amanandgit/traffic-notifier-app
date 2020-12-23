package com.notifier.traffic.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notifier.traffic.entity.Crime;

/** Connects Crime table using JPA.
 * @author Aman Anand
 *
 */
public interface CrimeDao extends JpaRepository<Crime, Long> {
	
	List<Crime> findByVehicleNumber(String vehicleNumber);
	
	List<Crime> findAllByViolationDateGreaterThan(LocalDate LocalDate);
}