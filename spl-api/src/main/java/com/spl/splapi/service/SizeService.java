package com.spl.splapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.splapi.model.Size;
import com.spl.splapi.repository.SizeRepository;

@Service
public class SizeService {

	@Autowired
	private SizeRepository sizeRepository;

	public List<Size> getAll() {
		return sizeRepository.findAll();
	}

	public Object getById(int id) {
		return sizeRepository.findById(id).orElse(null);
	}

	public Object save(Size size) {
		return sizeRepository.save(size);
	}

	public Object updateById(int id, Size size) {
		if (Objects.isNull(getById(id)))
			return null;
		return sizeRepository.save(size);
	}

	public Object deleteById(int id) {
		if (Objects.isNull( getById(id)))
			return null;
		sizeRepository.deleteById(id);
		return "success";
	}
}
