package com.insurance.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurance.app.dto.CustomerInsuranceRequestDto;
import com.insurance.app.dto.CustomerResponseDto;
import com.insurance.app.dto.FundTransferRequestDto;
import com.insurance.app.dto.InsuranceRequestDto;
import com.insurance.app.entity.Customer;
import com.insurance.app.entity.CustomerInsurance;
import com.insurance.app.entity.InsurancePolicy;
import com.insurance.app.exception.CustomerInsuranceNotFoundException;
import com.insurance.app.exception.CustomerNotFoundException;
import com.insurance.app.feignclient.MyBankClient;
import com.insurance.app.repository.ApplyInsuranceRepository;
import com.insurance.app.repository.InsuranceCompanyRepository;
import com.insurance.app.repository.UserServiceRepository;
import com.insurance.app.service.CustomerInsuranceService;
@Service
public class CustomerInsuranceServiceImpl implements CustomerInsuranceService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerInsuranceServiceImpl.class);


	@Autowired
	UserServiceRepository userServiceRepository;
	
	@Autowired
	InsuranceCompanyRepository insuranceCompanyRepository;
	
	@Autowired
	ApplyInsuranceRepository applyInsuranceRepository;
	
	@Autowired
	MyBankClient myBankClient;
	
	@Override
	@Transactional
	public void applyCustomerPolicy(CustomerInsuranceRequestDto customerInsuranceRequestDto) throws CustomerInsuranceNotFoundException {
		Long fromAccount=customerInsuranceRequestDto.getFromAccount();
		int customerId=customerInsuranceRequestDto.getCustomerId();
		
		List<InsuranceRequestDto> insuranceDtoList=new ArrayList<>();
		
		/*
		for(InsuranceRequestDto insurance:customerInsuranceRequestDto.getInsuranceRequestDto()) {
			insuranceDtoList.add(insurance);
		}*/
		customerInsuranceRequestDto.getInsuranceRequestDto().stream().forEach(insurance->insuranceDtoList.add(insurance));
		
		Optional<Customer> optionalCustomer=userServiceRepository.findById(customerId);
		 if (optionalCustomer.isPresent()) { 
			Customer customer=optionalCustomer.get();
			
			//for(InsuranceRequestDto insurances :insuranceDtoList) 
				insuranceDtoList.stream().forEach(insurances->{
				Optional<InsurancePolicy> policy;
				policy=insuranceCompanyRepository.findById(insurances.getPolicyId());
				
				if(policy.isPresent()) {
					InsurancePolicy insurancepolicy=policy.get();
					boolean monthlyEmi=insurances.isMonthlyEMI();
					boolean yearlyEmi=insurances.isYearlyEMI();
					long toAccount=insurancepolicy.getToAccount();
					long transferFund;
					long totalFundTransfer=0;
					
					 if(yearlyEmi) {
						 logger.info("Customer selected yearly Emi");
						 transferFund=insurancepolicy.getInsurancePolicyEmiYearly();
						 totalFundTransfer = (totalFundTransfer+transferFund);
						 FundTransferRequestDto fundTransferRequestDto= new FundTransferRequestDto();
						 fundTransferRequestDto.setToAccount(insurancepolicy.getToAccount());
						 fundTransferRequestDto.setFromAccountNumber(fromAccount);
						 fundTransferRequestDto.setAmount(totalFundTransfer);
						 fundTransferRequestDto.setRemarks("Insurance Payment");
						 myBankClient.fundTransfer(fundTransferRequestDto);
						 
						 
					 }
					 else {
						 logger.info("Customer selected monthly Emi");
						transferFund=insurancepolicy.getInsurancePolicyEmiMonthly();
						totalFundTransfer = (totalFundTransfer+transferFund);
						FundTransferRequestDto fundTransferRequestDto= new FundTransferRequestDto();
						fundTransferRequestDto.setToAccount(insurancepolicy.getToAccount());
						fundTransferRequestDto.setFromAccountNumber(fromAccount);
						fundTransferRequestDto.setAmount(totalFundTransfer);
						 fundTransferRequestDto.setRemarks("Insurance Payment");
						 
						 myBankClient.fundTransfer(fundTransferRequestDto);
						 logger.info("Fund Transfer Successfully to :"+toAccount);
						
					 }
					 /*
					 CustomerResponseDto customerResponseDto=new CustomerResponseDto();
					 customerResponseDto.setPolicyId(insurancepolicy.getInsurancePolicyId());
					 customerResponseDto.setPolicyName(insurancepolicy.getInsurancePolicyName());
					 */
					
					CustomerInsurance customerInsurance=new CustomerInsurance();
					customerInsurance.setPolicyId(insurancepolicy.getInsurancePolicyId());
					//customerInsurance.setPolicyName(insurancepolicy.getInsurancePolicyName());
					//customerInsurance.setInsuranceSumAssured(insurancepolicy.getInsurancePolicySumAssured());
					customerInsurance.setStatus("Success");
					customerInsurance.setCustomerId(customerId);
					
					applyInsuranceRepository.save(customerInsurance);
					logger.info("Insurances applied Successfully.");
					
				}else {
						logger.warn("PolicyId doesn't exist");
						throw new CustomerInsuranceNotFoundException("The PolicyID doesn't exist");
					}
				
			
			});
		}
		
		
			
  }
		


	/*
	private boolean checkValidCustomer(int customerId) {
		Optional<Customer> optionalCustomer=userServiceRepository.findById(customerId);
		if (optionalCustomer.isPresent()) {
			return true;
		}
		return false;
	}
	*/

}
