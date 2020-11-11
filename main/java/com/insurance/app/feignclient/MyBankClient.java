package com.insurance.app.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.insurance.app.dto.FundTransferRequestDto;

//@FeignClient(name = "http://MYBANK-SERVICE/bank/SBI")
@FeignClient(value ="mybank-service", url = "http://localhost:8082/bank/SBI")
public interface MyBankClient {
	@PostMapping("/transfer")
	public String fundTransfer(@RequestBody FundTransferRequestDto fundTransferRequestDto);

	@GetMapping("/port")
	public String getInfo();

}
