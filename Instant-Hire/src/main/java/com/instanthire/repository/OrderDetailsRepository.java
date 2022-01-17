package com.instanthire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instanthire.model.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

	List<OrderDetails> findByCustomerId(Long customerId);

	List<OrderDetails> findByEmployeeId(Long employeeId);

	List<OrderDetails> findByEmployeeIdAndStatus(Long id, String string);
	
}
