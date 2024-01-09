package com.tvmemp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmemp.model.EmployeeLog;
import com.tvmemp.model.EmployeeLogout;
import com.tvmemp.repository.EmployeeLogRepo;
import com.tvmemp.repository.EmployeeLogoutRepo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/tvm")
public class EmployeeLogController {

	@Autowired
	private EmployeeLogRepo repo;

	@Autowired
	private EmployeeLogoutRepo logoutrepo;
	
	

	@PostMapping("/savelogout")
	public EmployeeLogout saveLogout(@RequestBody EmployeeLogout emplog) {
		return logoutrepo.save(emplog);
	}

	@PostMapping("/savelogin")
	public EmployeeLog saveLog(@RequestBody EmployeeLog emplog) {
		return repo.save(emplog);
	}
	
	@GetMapping("/getLogdetails/id")
	public Optional<EmployeeLog> getMethodName(@PathVariable("id") Integer id) {
		
		return repo.findById(id);
		
	}
	

}
