package com.insurance.app.service;

import java.util.List;

import com.insurance.app.entity.CustomerInsurance;

public interface CustomerService {

	List<CustomerInsurance> getCustomerInsuranceList(int customerId, int pageNumber, int pageSize);

}
