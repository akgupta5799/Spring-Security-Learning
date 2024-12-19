package com.themathcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.themathcode.entity.Employee;
import java.util.List;


public interface EmpRepo extends JpaRepository<Employee, Integer>{

	public Employee findByEmail(String email);
}
