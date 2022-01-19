package com.spl.splapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.splapi.model.Locker;
import com.spl.splapi.repository.LockerRepository;

@Service
public class LockerService {

	@Autowired
	private LockerRepository lockerRepository;

	public List<Locker> getAll() {
		return lockerRepository.findAll();
	}

	public Object getById(int id) {
		return lockerRepository.findById(id).orElse(null);
	}

	public Object save(Locker locker) {
		return lockerRepository.save(locker);
	}

	public Object updateById(int id, Locker locker) {
		if (Objects.isNull(getById(id)))
			return null;
		return lockerRepository.save(locker);
	}

	public Object deleteById(int id) {
		if (Objects.isNull( getById(id)))
			return null;
		lockerRepository.deleteById(id);
		return "success";
	}
}
