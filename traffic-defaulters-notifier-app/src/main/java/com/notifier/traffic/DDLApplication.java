package com.notifier.traffic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.notifier.traffic.dao.CrimeDao;
import com.notifier.traffic.dao.RuleCodeDao;
import com.notifier.traffic.dao.VehicleDao;
import com.notifier.traffic.entity.Crime;
import com.notifier.traffic.entity.RuleCode;
import com.notifier.traffic.entity.Vehicle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class DDLApplication {

	public static void main(String args[]) {
		ApplicationContext ac = SpringApplication.run(DDLApplication.class, args);
		log.info("*****************Trafic Fine-Notifier DDLApplication Started********************");
		
		VehicleDao vehicleRepository = ac.getBean(VehicleDao.class);
		CrimeDao crimeRepository = ac.getBean(CrimeDao.class);
		RuleCodeDao ruleCodeRepository = ac.getBean(RuleCodeDao.class);
		
		List<Vehicle> vehicles = new ArrayList<>();
		List<RuleCode> ruleCodes = new ArrayList<>();
		List<Crime> crimes = new ArrayList<>();
		
		RuleCode rc1 = new RuleCode(1001, 1000, "Reckless driving");//violationCode, fine, description
		RuleCode rc2 = new RuleCode(1002, 2000, "Using Phone");
		RuleCode rc3 = new RuleCode(1003, 2000, "Excess Luggage");
		RuleCode rc4 = new RuleCode(1004, 1000, "Driving Uninsured Vehicle");
		RuleCode rc5 = new RuleCode(1005, 10000, "No Registration");
		RuleCode rc6 = new RuleCode(1006, 5000, "No fitness certificate");
		RuleCode rc7 = new RuleCode(1007, 1000, "Violating road safety rules");
		RuleCode rc8 = new RuleCode(1008, 5000, "Wrong Parking");
		
		ruleCodes.add(rc1);
		ruleCodes.add(rc2);
		ruleCodes.add(rc3);
		ruleCodes.add(rc4);
		ruleCodes.add(rc5);
		ruleCodes.add(rc6);
		ruleCodes.add(rc7);
		ruleCodes.add(rc8);
		ruleCodeRepository.saveAll(ruleCodes);
		
		vehicles.add(new Vehicle("BR09A2345","Bihar", "CAR","Honda","Arun Kumar","arun@gmail.com"));///vehicleNumber, state, type, name, ownerName, emailId
		vehicles.add(new Vehicle("BR09A2346","Bihar", "CAR","Maruti","Aman Anand","amananand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2347","Bihar", "CAR","Honda","Ankur Kumar","ankur@gmail.com"));
		vehicles.add(new Vehicle("BR09A2348","Bihar", "BUS","Honda","Binod Kumar","binod@gmail.com"));
		vehicles.add(new Vehicle("BR09A2349","Bihar", "BUS","Honda","Arun Kumar","arun@gmail.com"));
		vehicles.add(new Vehicle("BR09A2350","Bihar", "CAR","Honda","Prasad Kumar","arun@gmail.com"));
		vehicles.add(new Vehicle("BR09A2351","Bihar", "CAR","Honda","Sumit Kumar","sumit@gmail.com"));
		vehicles.add(new Vehicle("BR09A2352","Bihar", "CAR","Honda","Ankit Kumar","ankit@gmail.com"));
		vehicles.add(new Vehicle("BR09A2353","Bihar", "TRACTOR","Honda","Bablu Kumar","bablu@gmail.com"));
		vehicles.add(new Vehicle("BR09A2354","Bihar", "CAR","Honda","Raina Y","raina@gmail.com"));
		vehicles.add(new Vehicle("BR09A2355","Bihar", "CAR","Honda","Dhoni Kumar","dhoni@gmail.com"));
		vehicles.add(new Vehicle("BR09A2356","Bihar", "BIKE","Honda","Ramesh Kumar","arun@gmail.com"));
		vehicles.add(new Vehicle("BR09A2357","Bihar", "BIKE","Honda","Indrajit Kumar","arun@gmail.com"));
		vehicles.add(new Vehicle("BR09A2358","Bihar", "CAR","Honda","Vibha Kumari","arun@gmail.com"));
		vehicles.add(new Vehicle("BR09A2359","Bihar", "BIKE","Honda","Alok Kumar","arun@gmail.com"));
		vehicles.add(new Vehicle("BR09A2360","Bihar", "CAR","Honda","Animesh Kumar","arun@gmail.com"));
		vehicles.add(new Vehicle("BR09A2361","Bihar", "SCOOTY","Honda","Balram Kumar","arun@gmail.com"));
		vehicles.add(new Vehicle("BR09A2362","Bihar", "CAR","Honda","Abhi Kumar","arun@gmail.com"));
		vehicles.add(new Vehicle("BR09A2363","Bihar", "SCOOTY","Honda","Chintu Kumar","arun@gmail.com"));
		vehicles.add(new Vehicle("BR09A2364","Bihar", "CAR","Honda","Bhola Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2365","Bihar", "CAR","Honda","Gola Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2366","Bihar", "CAR","Honda","Mahesh Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2367","Bihar", "CAR","Honda","Rakesh Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2368","Bihar", "BIKE","Honda","Ajay Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2369","Bihar", "BIKE","Honda","Vijay Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2370","Bihar", "CAR","Honda","Rohan Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2371","Bihar", "CAR","Honda","Sohan Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2372","Bihar", "CAR","Honda","Guptil Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2373","Bihar", "BIKE","Honda","Putul Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2374","Bihar", "CAR","Honda","Rohan Gupta","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2375","Bihar", "CAR","Honda","Anamika Kumari","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2376","Bihar", "CAR","Honda","Arun Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2377","Bihar", "BIKE","Honda","Jay Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2378","Bihar", "BUS","Honda","Prem Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2379","Bihar", "CAR","Honda","Shiva Kumar","amanand92@gmail.com"));
		vehicles.add(new Vehicle("BR09A2380","Bihar", "BUS","Honda","Nathu Kumar","amanand92@gmail.com"));
		
		vehicleRepository.saveAll(vehicles);
		
		crimes.add(new Crime(1001,"BR09A2364",LocalDate.now(),"Pending"));//violationCode, vehicleNumber, violationDate
		crimes.add(new Crime(1002,"BR09A2365",LocalDate.now().minusDays(2), "Pending"));
		crimes.add(new Crime(1003,"BR09A2366",LocalDate.now().minusDays(4), "Pending"));
		crimes.add(new Crime(1004,"BR09A2367",LocalDate.now().minusDays(3),"Pending"));
		crimes.add(new Crime(1001,"BR09A2368",LocalDate.now().minusDays(6),"Pending"));
		crimes.add(new Crime(1005,"BR09A2369",LocalDate.now().minusDays(7),"Pending"));
		crimes.add(new Crime(1006,"BR09A2370",LocalDate.now().minusDays(9),"Pending"));
		crimes.add(new Crime(1007,"BR09A2371",LocalDate.now().minusDays(10),"Pending"));
		crimes.add(new Crime(1008,"BR09A2372",LocalDate.now().minusDays(11),"Pending"));
		crimes.add(new Crime(1001,"BR09A2373",LocalDate.now().minusDays(1),"Pending"));
		crimes.add(new Crime(1003,"BR09A2374",LocalDate.now().minusDays(14),"Pending"));
		crimes.add(new Crime(1004,"BR09A2375",LocalDate.now().minusDays(5),"Pending"));
		crimes.add(new Crime(1005,"BR09A2376",LocalDate.now().minusDays(2),"Pending"));
		crimes.add(new Crime(1007,"BR09A2377",LocalDate.now().minusDays(2),"Pending"));
		crimes.add(new Crime(1006,"BR09A2378",LocalDate.now().minusDays(1),"Pending"));
		crimes.add(new Crime(1002,"BR09A2379",LocalDate.now().minusDays(4),"Pending"));
		
		crimeRepository.saveAll(crimes);
		log.info("*****************VehicleDB Updated*******************");
	}
}
