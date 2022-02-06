package com.spl.splapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.splapi.model.Parcel;
import com.spl.splapi.repository.ParcelRepository;

@Service
public class ParcelService {

	@Autowired
	private ParcelRepository parcelRepository;

	public List<Parcel> getAll() {
		return parcelRepository.findAll();
	}

	public Object getById(int id) {
		return parcelRepository.findById(id).orElse(null);
	}

	public Object save(Parcel parcel) {
		return parcelRepository.save(parcel);
	}

	public Object updateById(int id, Parcel parcel) {
		if (Objects.isNull(getById(id)))
			return null;
		return parcelRepository.save(parcel);
	}

	public Object deleteById(int id) {
		if (Objects.isNull( getById(id)))
			return null;
		parcelRepository.deleteById(id);
		return "success";
	}
	
	public Object findFirstByBarcode(String barcode) {
		return parcelRepository.findFirstByBarcode(barcode);
	}
	
	public Object findFirstByQrcode(String qrcode) {
		return parcelRepository.findFirstByQrcode(qrcode);
	}
	
	public Object findFirstByNameContaining(String name) {
		return parcelRepository.findFirstByNameContaining(name);
	}
}
