package com.insurance.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="insurance_policy")
public class InsurancePolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long insurancePolicyId;
    private String insurancePolicyName;
    private String insurancePolicyDesc;
    private String insurancePolicyTenure;
    private Long insurancePolicySumAssured;
    private Long insurancePolicyEmiMonthly;
    private Long insurancePolicyEmiYearly;
    private Long insurancePolicyBenfitAmount;
    private Long toAccount;
	public Long getInsurancePolicyId() {
		return insurancePolicyId;
	}
	public void setInsurancePolicyId(Long insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}
	public String getInsurancePolicyName() {
		return insurancePolicyName;
	}
	public void setInsurancePolicyName(String insurancePolicyName) {
		this.insurancePolicyName = insurancePolicyName;
	}
	public String getInsurancePolicyDesc() {
		return insurancePolicyDesc;
	}
	public void setInsurancePolicyDesc(String insurancePolicyDesc) {
		this.insurancePolicyDesc = insurancePolicyDesc;
	}
	public String getInsurancePolicyTenure() {
		return insurancePolicyTenure;
	}
	public void setInsurancePolicyTenure(String insurancePolicyTenure) {
		this.insurancePolicyTenure = insurancePolicyTenure;
	}
	public Long getInsurancePolicySumAssured() {
		return insurancePolicySumAssured;
	}
	public void setInsurancePolicySumAssured(Long insurancePolicySumAssured) {
		this.insurancePolicySumAssured = insurancePolicySumAssured;
	}
	public Long getInsurancePolicyEmiMonthly() {
		return insurancePolicyEmiMonthly;
	}
	public void setInsurancePolicyEmiMonthly(Long insurancePolicyEmiMonthly) {
		this.insurancePolicyEmiMonthly = insurancePolicyEmiMonthly;
	}
	public Long getInsurancePolicyEmiYearly() {
		return insurancePolicyEmiYearly;
	}
	public void setInsurancePolicyEmiYearly(Long insurancePolicyEmiYearly) {
		this.insurancePolicyEmiYearly = insurancePolicyEmiYearly;
	}
	public Long getInsurancePolicyBenfitAmount() {
		return insurancePolicyBenfitAmount;
	}
	public void setInsurancePolicyBenfitAmount(Long insurancePolicyBenfitAmount) {
		this.insurancePolicyBenfitAmount = insurancePolicyBenfitAmount;
	}
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
    
	
}
