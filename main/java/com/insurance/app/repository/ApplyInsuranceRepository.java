package com.insurance.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.app.dto.CustomerResponseDto;
import com.insurance.app.entity.CustomerInsurance;

public interface ApplyInsuranceRepository extends JpaRepository<CustomerInsurance, Long>{

	Page<CustomerInsurance> findByCustomerId(int customerId, Pageable pageable);

	void save(CustomerResponseDto customerResponseDto);

}
