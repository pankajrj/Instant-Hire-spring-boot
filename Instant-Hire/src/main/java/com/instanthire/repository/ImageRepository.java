package com.instanthire.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instanthire.model.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);

	Optional<ImageModel> findByEmployeeId(long imgid);
}
