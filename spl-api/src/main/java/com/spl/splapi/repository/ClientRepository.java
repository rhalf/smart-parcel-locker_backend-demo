package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spl.splapi.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	Client findFirstByBarcode(String barcode);
	
	Client findFirstByQrcode(String qrcode);

	Client findFirstByNameContaining(String name);
}
