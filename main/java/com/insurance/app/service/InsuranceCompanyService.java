package com.insurance.app.service;

import java.util.List;

import com.insurance.app.dto.InsurancePolicyDto;

public interface InsuranceCompanyService {

	List<InsurancePolicyDto> getListOfInsuranceCompanies(int pageNumber, int pageSize);

}
