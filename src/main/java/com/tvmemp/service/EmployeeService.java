package com.tvmemp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.tvmemp.model.TvmEmployee;

public interface EmployeeService {

	public TvmEmployee saveEmp(TvmEmployee employee);

	public Optional<TvmEmployee> getEmp(Integer id);

	public List<TvmEmployee> getAllEmp(TvmEmployee employee);

	public TvmEmployee updateEmployee(Integer id, TvmEmployee employee);

	public void deleteEmployee(Integer id);

	//filtering employee by specific details
	
	public List<TvmEmployee>getEmployeeBySalary(Long employeesalary );
	
	public List<TvmEmployee>getEmployeefirstName(String employeefirstname );
	
	public List<TvmEmployee>getEmployeeBylastName(String employeelastname );
	
	public List<Object[]> getEmployeeByPassout(String yearofPassout);
	
	// Getting Employee using Assets id
	
	public List<TvmEmployee> findByAssestId(Integer assestId);
	
	
    public List<TvmEmployee> findByAssestlaptop(String laptop);



	





	
}
