package com.stackoverflow.q47245185;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@Slf4j
public class RestTemplateDemo {

	private final RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateDemo.class, args);
	}

	@GetMapping("/get-payload")
	public ServiceResponse loadPayload(){
		ServicePayload servicePayload = new ServicePayload();
		servicePayload.setEmail("abc@test.com");
		servicePayload.setChances("verified");
		servicePayload.setDisplay("OK");
		servicePayload.setFromSystem("N");
		servicePayload.setPlainOutput("allOk");

		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setStatus("Passing");
		serviceResponse.setPayload(servicePayload);

		return serviceResponse;
	}

	@GetMapping("/call-endpoint")
	public ServiceResponse callEndpoint(){
		HttpEntity<ServiceResponse> responseHttpEntity = new HttpEntity<>(new ServiceResponse());

		ResponseEntity<ServiceResponse> response = restTemplate.exchange(
				"http://localhost:8080/get-payload",
				HttpMethod.GET,
				responseHttpEntity,
				ServiceResponse.class
		);

		if(response.getBody() != null && response.getBody().getPayload() != null) {
			log.info("Email from request: {}", response.getBody().getPayload().getEmail());
		} else {
			log.error("Payload is null");
		}

		return response.getBody();
	}
}
