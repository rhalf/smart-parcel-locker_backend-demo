package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spl.splapi.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
}