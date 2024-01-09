package com.tvmemp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.tvmemp.model.TvmEmployee;
import com.tvmemp.repository.TvmEmployeeRepository;

/**
 * EmployeeServiceImpl class
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private TvmEmployeeRepository repo;

	/**
	 * save employee details
	 */
	@Override
	public TvmEmployee saveEmp(TvmEmployee employee) {
		return repo.save(employee);
	}

	// get
	@Override
	public Optional<TvmEmployee> getEmp(Integer id) {

		return repo.findById(id);

	}

	// getAll
	@Override
	public List<TvmEmployee> getAllEmp(TvmEmployee employee) {
		return repo.findAll();
	}

	// put
	@Override
	public TvmEmployee updateEmployee(Integer id, TvmEmployee employee) {

		Optional<TvmEmployee> tvm = repo.findById(id);
		TvmEmployee emp1 = tvm.get();
		emp1.setEmployeeEmail(employee.getEmployeeEmail());
		emp1.setEmployeeeSalary(employee.getEmployeeeSalary());
		emp1.setEmployeeFirstname(employee.getEmployeeFirstname());
		emp1.setEmployeeLastname(employee.getEmployeeLastname());
		emp1.setEmployeePhone(employee.getEmployeePhone());
		emp1.setEmployeeAddress(employee.getEmployeeAddress());
		emp1.setEmployeeEducation(employee.getEmployeeEducation());
		return repo.save(emp1);

	}

	// delete
	@Override
	public void deleteEmployee(Integer id) {

		repo.deleteById(id);

	}

	@Override
	public List<TvmEmployee> getEmployeeBySalary(Long employeesalary) {
		
		return repo.getEmployeeBySalary(employeesalary);
	}


    

	
	

}
