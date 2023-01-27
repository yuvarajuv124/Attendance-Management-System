package com.example.miniproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.miniproject.model.Address;

public interface AddressRepository extends CrudRepository<Address,Integer> {

}
