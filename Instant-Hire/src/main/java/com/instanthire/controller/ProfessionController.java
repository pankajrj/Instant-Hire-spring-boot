package com.instanthire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instanthire.exeption.ResourceNotFoundException;
import com.instanthire.model.Profession;
import com.instanthire.repository.ProfessionRepository;

@RestController
@CrossOrigin
@RequestMapping("/instanthire/profession/")
public class ProfessionController {
	
	@Autowired
	private ProfessionRepository professionRepository ;
	
	@GetMapping("/professions")
	@CrossOrigin
	public List<Profession>getProfessionList() {
		return professionRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/getProfessionbyid/{id}")
	public ResponseEntity<Profession> getProfessionById(@PathVariable long id){
		Profession p=professionRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("not found"));
		return ResponseEntity.ok(p);
	}
	
	

}
