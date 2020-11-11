package com.insurance.app.exception;

public class InsuranceCompanyNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InsuranceCompanyNotFoundException(String message) {
		super(message);
	}

}
