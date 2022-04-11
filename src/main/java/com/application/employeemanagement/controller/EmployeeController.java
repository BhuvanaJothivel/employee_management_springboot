package com.application.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.employeemanagement.dao.EmployeeDao;
import com.application.employeemanagement.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao empdao;
	
	@PostMapping("addemployee")
	public Employee addEmployee(@RequestBody Employee emp) {
		return empdao.save(emp);
	}
	
	@PutMapping("editemployee")
	public Employee EditEmployee(@RequestBody Employee emp) {
		return empdao.save(emp);
	}
	
	@DeleteMapping("deleteallemployee")
	public String deleteAllEmp() {
		String result = "";
		try {
			empdao.deleteAll();
			result = "all records deleted";
		}catch (Exception e) {
			result = "error occurred";
		}
		return result;
	}
	
	@DeleteMapping("deleteemployee/{id}")
	public String deleteEmpById(@PathVariable int id) {
		String result = "";
		try {
			empdao.deleteById(id);
			result = "employee record deleted";
		}catch (Exception e) {
			result = "error occurred";
		}
		return result;
	}
	
	@GetMapping("getallemployee")
	public List<Employee> getAllEmp() {
		return empdao.findAll();
	}
	
	@GetMapping("getemployee/{id}")
	public Optional<Employee> getEmpById(@PathVariable int id) {
		return empdao.findById(id);
	}
	
	@GetMapping("getemployeebyctc/{ctc}")
	public List<Employee> getEmpByCTC(@PathVariable int ctc) {
		return empdao.findByCtc(ctc);
	}
	
}
