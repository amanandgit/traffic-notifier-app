package com.notifier.traffic.service;

import java.util.List;

import com.notifier.traffic.vo.Defaulter;

/** This interface has methods for Defaulter Service.
 * @author Aman Anand
 *
 */
public interface SearchDefaulterService {

	List<Defaulter> getDefaultersListForLastWeek();
}
