package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spl.splapi.model.Courier;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Integer> {
	
	Courier findFirstByBarcode(String barcode);
	
	Courier findFirstByQrcode(String qrcode);

	Courier findFirstByNameContaining(String name);
}