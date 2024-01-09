package com.tvmemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tvmemp.model.EmployeeLog;

public interface EmployeeLogRepo extends JpaRepository<EmployeeLog, Integer> {
	
	@Query(value="SELECT el.logid,el.logindate,el.logintime,el.employeeid,eo.logid,eo.logoutdate,eo.logintime,eo.employeeid FROM empoyeelog el LEFT JOIN emplogout eo "
			+ "ON el.employeeid=eo.employeeid where eo.logid=logid", nativeQuery = true)
	public List<EmployeeLog>getBylogid(Integer logid);

}
