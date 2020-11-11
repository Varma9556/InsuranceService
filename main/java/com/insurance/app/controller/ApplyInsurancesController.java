package com.insurance.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.app.dto.CustomerInsuranceRequestDto;
import com.insurance.app.exception.CustomerInsuranceNotFoundException;
import com.insurance.app.service.CustomerInsuranceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="InsurancesApplyForCustomer", description="REST Api for Apply MultipleInsurances",tags={"InsurancesApplyForCustomer"})
public class ApplyInsurancesController {
	
	@Autowired
	CustomerInsuranceService  customerInsuranceService;
	
	@ApiOperation(value="Post InsurancesApplyForCustomer", tags = {"InsurancesApplyForCustomer"})
	@PostMapping("/applyInsurances")
	public ResponseEntity<String> applyPolicy(@Valid @RequestBody CustomerInsuranceRequestDto customerInsuranceRequestDto)
				throws CustomerInsuranceNotFoundException{
		customerInsuranceService.applyCustomerPolicy(customerInsuranceRequestDto);
		return new ResponseEntity<String>("Your are Successfully Applied Insurance Policy",HttpStatus.ACCEPTED);
		
	}

}
