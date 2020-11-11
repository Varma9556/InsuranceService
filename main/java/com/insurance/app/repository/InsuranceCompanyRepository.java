package com.insurance.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.app.entity.InsurancePolicy;
@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsurancePolicy, Long> {

}
