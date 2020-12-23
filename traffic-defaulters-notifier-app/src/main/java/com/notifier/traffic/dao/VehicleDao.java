package com.notifier.traffic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notifier.traffic.entity.Vehicle;

/** Connects VehicleDao table using JPA.
 * @author Aman Anand
 *
 */
public interface VehicleDao extends JpaRepository<Vehicle, String> {
	Vehicle findByVehicleNumber(String vehicleNumber);
}