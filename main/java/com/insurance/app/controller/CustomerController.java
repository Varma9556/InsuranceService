package com.insurance.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.app.entity.CustomerInsurance;
import com.insurance.app.exception.CustomerNotFoundException;
import com.insurance.app.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@Api(value="CustomerInsurancesByCustomerId", description="REST Api for List of Customer Insurances",tags={"CustomerInsurancesByCustomerId"})
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@ApiOperation(value="GetCustomerInsurancesByCustomerId", tags = {"CustomerInsurancesByCustomerId"})
	@GetMapping("/searchListOfInsurancesbyCustomerId")
	public ResponseEntity<List<CustomerInsurance>> getCustomerInsuranceList
		(@Valid @RequestParam int customerId ,@RequestParam int pageNumber, @RequestParam int pageSize)
					throws CustomerNotFoundException{
		List<CustomerInsurance> customerInsurance=customerService.getCustomerInsuranceList(customerId,pageNumber,pageSize);
		return new ResponseEntity<List<CustomerInsurance>>(customerInsurance,HttpStatus.OK);
	}

}
