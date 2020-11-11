package com.insurance.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.insurance.app.entity.CustomerInsurance;
import com.insurance.app.exception.CustomerNotFoundException;
import com.insurance.app.repository.ApplyInsuranceRepository;
import com.insurance.app.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	ApplyInsuranceRepository applyInsuranceRepository;
	
	
	@Override
	public List<CustomerInsurance> getCustomerInsuranceList(int customerId, int pageNumber, int pageSize)
									throws CustomerNotFoundException{
		
		
		Page<CustomerInsurance> insurances;
		List<CustomerInsurance> customerInsurance=new ArrayList<>();
		Pageable pageable=PageRequest.of(pageNumber, pageSize);
		insurances=applyInsuranceRepository.findByCustomerId(customerId,pageable);
		
		if(insurances.isEmpty()) {
			logger.warn("The Customer is not registered any policy,you need to register");
			throw new CustomerNotFoundException("The Customer is not registered any policy");
		}
		//logger.warn("The Customer Dosen't exist, you need to Register");
	/*
		for(CustomerInsurance insurance:insurances) {
			customerInsurance.add(insurance);
			
		}
		*/
		logger.info("Getting the List of Insurances by customerId :{}",customerId);
		insurances.stream().forEach( insurance->customerInsurance.add(insurance) );
		
		return customerInsurance;
	}

}
