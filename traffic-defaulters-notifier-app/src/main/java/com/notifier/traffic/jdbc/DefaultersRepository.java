package com.notifier.traffic.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.CustomSql;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.notifier.traffic.vo.Defaulter;

import lombok.extern.slf4j.Slf4j;

/** This repository class is used to fetch the details of defaulter from Vehicle, crime and RuleCode tables.
 * @author Aman Anand
 *
 */
@Slf4j
@Repository
public class DefaultersRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Defaulter> getDefaulters() throws Exception{
		//SELECT DISTINCT c.vehicle_number as vehicle_number, c.violation_code as violation_code,  v.email_id as email_id , v.owner_name as owner_name, c.violation_date as violation_date, r.fine as fine FROM crime c INNER JOIN vehicle v ON (c.vehicle_number = v.vehicle_number) INNER JOIN rule_code r ON (r.violation_code = c.violation_code) WHERE (C.VIOLATION_DATE > '2020-12-18')

		SelectQuery query = new SelectQuery()
				.addCustomColumns(new CustomSql("c.vehicle_number as vehicle_number, c.violation_code as violation_code, "
						+ " v.email_id as email_id , v.owner_name as owner_name, c.violation_date as violation_date, r.fine as fine, r.description as description"))
				.setIsDistinct(true)
				.addCustomJoin(SelectQuery.JoinType.INNER, new CustomSql("crime c"),new CustomSql("vehicle v"), 
						BinaryCondition.equalTo(new CustomSql("c.vehicle_number"), new CustomSql("v.vehicle_number")))
				.addCustomJoin(SelectQuery.JoinType.INNER, new CustomSql("crime c"),new CustomSql("rule_code r"),
						BinaryCondition.equalTo(new CustomSql("r.violation_code"), new CustomSql("c.violation_code")))
				.addCondition(BinaryCondition.greaterThan(new CustomSql("C.VIOLATION_DATE"), LocalDate.now().minusDays(7)));
		log.info(query.toString());
		
		try {
			return jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<>(Defaulter.class));
		} catch (DataAccessException e) {
			log.error("DefaultersRepository.getDefaulters >> error occured while fetching data"+e.getMessage());
		}
		return new ArrayList<>();
	}

	public List<Defaulter> getDefaultersGreaterThanSeventy() {
		SelectQuery query = new SelectQuery()
				.addCustomColumns(new CustomSql("c.vehicle_number as vehicle_number, c.violation_code as violation_code, "
						+ " v.email_id as email_id , v.owner_name as owner_name, c.violation_date as violation_date, r.fine as fine, r.description as description"))
				.setIsDistinct(true)
				.addCustomJoin(SelectQuery.JoinType.INNER, new CustomSql("crime c"),new CustomSql("vehicle v"), 
						BinaryCondition.equalTo(new CustomSql("c.vehicle_number"), new CustomSql("v.vehicle_number")))
				.addCustomJoin(SelectQuery.JoinType.INNER, new CustomSql("crime c"),new CustomSql("rule_code r"),
						BinaryCondition.equalTo(new CustomSql("r.violation_code"), new CustomSql("c.violation_code")));
				//.addCondition(BinaryCondition.greaterThan(new CustomSql("C.VIOLATION_DATE"), LocalDate.now().minusDays(7)));
		log.info(query.toString());
		
		try {
			return jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<>(Defaulter.class));
		} catch (DataAccessException e) {
			log.error("DefaultersRepository.getDefaulters >> error occured while fetching data"+e.getMessage());
		}
		return new ArrayList<>();
	}
}
