package com.instanthire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instanthire.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	Employee findByEmployeeEmailAndEmployeePassword(String employeeEmail, String employeePassword);

	List<Employee> findByProfessionId(int id);

	Employee findByEmployeeEmail(String emailId);

	List<Employee> findByEmployeeRating(int i);

	List<Employee> findByEmployeeCity(String city);

}
