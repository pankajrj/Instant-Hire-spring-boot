package com.instanthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instanthire.model.FeedbackModel;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackModel, Long> {

}
