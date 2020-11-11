package com.insurance.app.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.insurance.app.dto.InsurancePolicyDto;
import com.insurance.app.entity.InsurancePolicy;
import com.insurance.app.exception.CustomerNotFoundException;
import com.insurance.app.exception.InsuranceCompanyNotFoundException;
import com.insurance.app.repository.InsuranceCompanyRepository;
import com.insurance.app.service.InsuranceCompanyService;

@Service
public class InsuranceCompanyServiceImpl implements InsuranceCompanyService {
	private static final Logger logger = LoggerFactory.getLogger(InsuranceCompanyServiceImpl.class);
	@Autowired
	InsuranceCompanyRepository insuranceCompanyRepository;

	@Override
	public List<InsurancePolicyDto> getListOfInsuranceCompanies(int pageNumber, int pageSize) throws InsuranceCompanyNotFoundException {
		Page<InsurancePolicy> policy;
		List<InsurancePolicyDto> insurancePolicyList=new ArrayList<>();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		policy=insuranceCompanyRepository.findAll(pageable);
		if(policy.isEmpty()) {
			logger.warn("The Insurance Companies are not available");
			throw new InsuranceCompanyNotFoundException("The Insurance Companies are not available");
		}
		
		/*
		for(InsurancePolicy policies:policy) {
			InsurancePolicyDto insurancePolicyDto=new InsurancePolicyDto();
			BeanUtils.copyProperties(policies, insurancePolicyDto);
			insurancePolicyList.add(insurancePolicyDto);
		}
		*/
		logger.info("Getting the List of Insurances");
		policy.stream().forEach(insurancePolicy ->{
			InsurancePolicyDto insurancePolicyDto=new InsurancePolicyDto();
			BeanUtils.copyProperties(insurancePolicy, insurancePolicyDto);
			insurancePolicyList.add(insurancePolicyDto);
		});
		return insurancePolicyList;
	}

	
}
