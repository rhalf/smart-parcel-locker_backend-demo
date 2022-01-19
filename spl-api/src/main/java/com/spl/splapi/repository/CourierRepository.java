package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spl.splapi.model.Courier;

public interface CourierRepository extends JpaRepository<Courier, Integer> {
	
}