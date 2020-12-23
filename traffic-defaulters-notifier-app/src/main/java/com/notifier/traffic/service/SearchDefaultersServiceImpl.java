package com.notifier.traffic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.notifier.traffic.jdbc.DefaultersRepository;
import com.notifier.traffic.vo.Defaulter;

/** This class is designed to fetch the list of defaulter.
 * @author Aman Anand
 *
 */
@Component
public class SearchDefaultersServiceImpl {
	
	@Autowired
	private DefaultersRepository defaultersDao;
	
	public List<Defaulter> getDefaultersListForLastWeek() throws Exception {
		return defaultersDao.getDefaulters();
	}

	public List<Defaulter> getDefaultersListForVehiclesGreaterthanSeventy() {
		return defaultersDao.getDefaultersGreaterThanSeventy();
		
	}
}
