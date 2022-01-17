package com.instanthire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instanthire.model.FeedbackModel;
import com.instanthire.repository.FeedbackRepository;

@CrossOrigin
@RestController
@RequestMapping("/instanthire/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	
	@PostMapping("/enquiry")
	public FeedbackModel sendEnquiryFeedback(@RequestBody FeedbackModel fed){
		 return this.feedbackRepository.save(fed);
	}
}
