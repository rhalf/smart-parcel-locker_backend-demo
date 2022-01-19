package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spl.splapi.model.Locker;

public interface LockerRepository extends JpaRepository<Locker, Integer> {
	
}