package com.insurance.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.insurance.app.dto.InsurancePolicyDto;
import com.insurance.app.exception.InsuranceCompanyNotFoundException;
import com.insurance.app.service.InsuranceCompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="ListOfInsurances", description="REST Api for List of Insurances",tags={"ListOfInsurances"})
public class InsuranceCompanyController {
	
	@Autowired
	InsuranceCompanyService insuranceCompanyService;
	
	
	@ApiOperation(value="GetListofInsurances", tags = {"ListOfInsurances"})
	@GetMapping("/list of Insurances")
	public ResponseEntity<List<InsurancePolicyDto>> listOfInsuranceCompanies(@RequestParam int pageNumber, @RequestParam int pageSize)
				throws InsuranceCompanyNotFoundException{
		List<InsurancePolicyDto> insurancePolicyDto=insuranceCompanyService.getListOfInsuranceCompanies(pageNumber,pageSize);
		return new ResponseEntity<List<InsurancePolicyDto>>(insurancePolicyDto,HttpStatus.OK);
		
	}

}
