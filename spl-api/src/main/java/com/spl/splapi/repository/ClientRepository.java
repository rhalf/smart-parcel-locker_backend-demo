package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spl.splapi.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
