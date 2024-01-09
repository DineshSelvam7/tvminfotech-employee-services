package com.tvmemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tvmemp.model.TvmEmployee;

public interface TvmEmployeeRepository extends JpaRepository<TvmEmployee, Integer>{
	
	@Query(value="SELECT * from tvmemployee n WHERE n.employeesalary>:employeesalary", nativeQuery = true)
	public List<TvmEmployee>getEmployeeBySalary(Long employeesalary );
	
	

}
