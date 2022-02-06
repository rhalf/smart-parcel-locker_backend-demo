package com.spl.splapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.splapi.model.Client;
import com.spl.splapi.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public Object getById(int id) {
		return clientRepository.findById(id).orElse(null);
	}

	public Object save(Client client) {
		return clientRepository.save(client);
	}

	public Object updateById(int id, Client client) {
		if (Objects.isNull(getById(id)))
			return null;
		return clientRepository.save(client);
	}

	public Object deleteById(int id) {
		if (Objects.isNull(getById(id)))
			return null;
		clientRepository.deleteById(id);
		return "success";
	}
	
	public Object findFirstByBarcode(String barcode) {
		return clientRepository.findFirstByBarcode(barcode);
	}
	
	public Object findFirstByQrcode(String qrcode) {
		return clientRepository.findFirstByQrcode(qrcode);
	}
	
	public Object findFirstByNameContaining(String name) {
		return clientRepository.findFirstByNameContaining(name);
	}

}
