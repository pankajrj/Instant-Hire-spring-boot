package com.instanthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instanthire.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Customer findByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);

	Customer findByCustomerEmail(String emailId);


}
