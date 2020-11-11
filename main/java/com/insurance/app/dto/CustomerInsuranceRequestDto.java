package com.insurance.app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerInsuranceRequestDto {
	@NotNull(message="AccountNumber is mandatory")
	@Min(value=0, message="Enter valid  AccountNumber")
	//@Size(max=15, message="Enter valid AccountNumber")
    @Digits(fraction = 0, integer = 15, message="AccountNumber Not accepted")
   // @Column(name = "account_number")
	private Long fromAccount;
	
	@NotNull(message="Customer Id is mandatory")
	@Min(value=0, message="Enter valid  Customer Id")
	@Max(value=6, message="Enter valid CustomerId")
    @Digits(fraction = 0, integer = 3, message="Customer Id Not accepted")
    @Column(name = "customer_id")
	@NotNull(message="Customer Id is mandatory")
	private int customerId;
	private List<InsuranceRequestDto> insuranceRequestDto =new ArrayList<>();
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<InsuranceRequestDto> getInsuranceRequestDto() {
		return insuranceRequestDto;
	}
	public void setInsuranceRequestDto(List<InsuranceRequestDto> insuranceRequestDto) {
		this.insuranceRequestDto = insuranceRequestDto;
	}
	/*
	public Iterable<InsuranceRequestDto> stream() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	

}
