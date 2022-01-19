package com.spl.splapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.splapi.model.Company;
import com.spl.splapi.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public List<Company> getAll() {
		return companyRepository.findAll();
	}

	public Object getById(int id) {
		return companyRepository.findById(id).orElse(null);
	}

	public Object save(Company company) {
		return companyRepository.save(company);
	}

	public Object updateById(int id, Company company) {
		if (Objects.isNull(getById(id)))
			return null;
		return companyRepository.save(company);
	}

	public Object deleteById(int id) {
		if (Objects.isNull(getById(id)))
			return null;
		companyRepository.deleteById(id);
		return "success";
	}
}
