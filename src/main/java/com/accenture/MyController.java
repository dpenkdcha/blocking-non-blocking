package com.accenture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class MyController {
	@Autowired
	MyService ms;
	
	@RequestMapping("/data")
	public List<String> getData() throws InterruptedException {
		return ms.getData();
	}
	
	@RequestMapping("/fluxdata")
	public Flux<String> getDataUsingFlux() throws InterruptedException {
		return ms.getDataUsingFlux();
	}
}
 