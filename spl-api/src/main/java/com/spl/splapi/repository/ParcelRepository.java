package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spl.splapi.model.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Integer> {

	Parcel findFirstByBarcode(String barcode);
	
	Parcel findFirstByQrcode(String qrcode);

	Parcel findFirstByNameContaining(String name);
}