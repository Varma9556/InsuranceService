package com.insurance.app.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InsuranceRequestDto {
	@NotNull(message="PolicyId is Mandatory")
	//@Min(value=0)
	@Max(value = 20,message="Please Enter the Valid policyId")
	private Long policyId;
	
	private Boolean monthlyEMI;
	private Boolean yearlyEMI;
	
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public Boolean isMonthlyEMI() {
		return monthlyEMI;
	}
	public void setMonthlyEMI(Boolean monthlyEMI) {
		this.monthlyEMI = monthlyEMI;
	}
	public Boolean isYearlyEMI() {
		return yearlyEMI;
	}
	public void setYearlyEMI(Boolean yearlyEMI) {
		this.yearlyEMI = yearlyEMI;
	}
	
	

}
