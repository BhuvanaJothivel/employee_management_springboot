package com.application.employeemanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.employeemanagement.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>{
	public List<Employee> findByCtc(int ctc);
//	public List<Employee> deleteByEmpDesignation(String designation);
}
