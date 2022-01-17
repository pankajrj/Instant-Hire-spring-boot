package com.instanthire.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instanthire.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	public Admin findByAdminEmailAndAdminPass(String adminEmail, String adminPass);

	public Admin findByAdminEmail(String emailId);

}
