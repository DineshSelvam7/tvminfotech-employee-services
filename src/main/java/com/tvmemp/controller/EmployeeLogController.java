package com.tvmemp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

@RestController
@RequestMapping("/tvm")
public class EmployeeLogController {

	@Autowired
	private EmployeeLogRepo loginrepo;

	@Autowired
	private EmployeeLogoutRepo logoutrepo;

	@PostMapping("/saveLogin")

	public EmployeeLog saveLogin(@RequestBody EmployeeLog login) {

		return loginrepo.save(login);
	}

	@PostMapping("/saveLogout")

	public EmployeeLogout saveLogout(@RequestBody EmployeeLogout logout) {

		return logoutrepo.save(logout);
	}

	// Getting login details By using employee id

	@GetMapping("/getLogdetails/{id}")
	public List<Object[]> getBylogid(@PathVariable("id") Integer id) {

		return loginrepo.getBylogid(id);
	}

}
