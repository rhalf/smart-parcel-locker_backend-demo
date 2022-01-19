package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spl.splapi.model.Size;

public interface SizeRepository extends JpaRepository<Size, Integer> {
	
}