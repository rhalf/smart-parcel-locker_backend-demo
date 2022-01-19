package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spl.splapi.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
