package com.notifier.traffic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notifier.traffic.entity.RuleCode;

/** Connects RuleCode table using JPA.
 * @author Aman Anand
 *
 */
public interface RuleCodeDao extends JpaRepository<RuleCode, Long> {

	RuleCode findByViolationCode(int vCode);
}