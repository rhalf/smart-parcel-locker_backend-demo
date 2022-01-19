package com.spl.splapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.splapi.model.Courier;
import com.spl.splapi.repository.CourierRepository;

@Service
public class CourierService {

	@Autowired
	private CourierRepository courierRepository;

	public List<Courier> getAll() {
		return courierRepository.findAll();
	}

	public Object getById(int id) {
		return courierRepository.findById(id).orElse(null);
	}

	public Object save(Courier courier) {
		return courierRepository.save(courier);
	}

	public Object updateById(int id, Courier courier) {
		if (Objects.isNull(getById(id)))
			return null;
		return courierRepository.save(courier);
	}

	public Object deleteById(int id) {
		if (Objects.isNull( getById(id)))
			return null;
		courierRepository.deleteById(id);
		return "success";
	}
}
