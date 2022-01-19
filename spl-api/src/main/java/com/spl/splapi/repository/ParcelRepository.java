package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spl.splapi.model.Parcel;

public interface ParcelRepository extends JpaRepository<Parcel, Integer> {
	
}