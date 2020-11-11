package com.insurance.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_insurance")
public class CustomerInsurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long policyNumber;
	
	private Long policyId;
	
	//private String policyName;
	private int customerId;
	//private Long insuranceSumAssured;
    private String status;
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public Long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(Long policyNumber) {
		this.policyNumber = policyNumber;
	}
	/*
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	*/
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/*
	
	public Long getInsuranceSumAssured() {
		return insuranceSumAssured;
	}
	public void setInsuranceSumAssured(Long insuranceSumAssured) {
		this.insuranceSumAssured = insuranceSumAssured;
	}
	*/
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
	
	

}
