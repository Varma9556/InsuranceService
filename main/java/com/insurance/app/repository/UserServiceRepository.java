package com.insurance.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.app.entity.Customer;

public interface UserServiceRepository extends JpaRepository<Customer, Integer> {

}
