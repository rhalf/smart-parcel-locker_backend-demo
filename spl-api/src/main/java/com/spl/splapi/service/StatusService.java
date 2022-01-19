package com.spl.splapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.splapi.model.Status;
import com.spl.splapi.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;

	public List<Status> getAll() {
		return statusRepository.findAll();
	}

	public Object getById(int id) {
		return statusRepository.findById(id).orElse(null);
	}

	public Object save(Status status) {
		return statusRepository.save(status);
	}

	public Object updateById(int id, Status status) {
		if (Objects.isNull(getById(id)))
			return null;
		return statusRepository.save(status);
	}

	public Object deleteById(int id) {
		if (Objects.isNull(getById(id)))
			return null;
		statusRepository.deleteById(id);
		return "success";
	}

}
