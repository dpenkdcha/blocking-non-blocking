package com.accenture;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class MyService {

	public List<String> getData() throws InterruptedException {
		int n = 25;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			System.out.println("adding element " + i);
			list.add("element:  " + i);
			Thread.sleep(1000);
		}
		return list;
	}

	public Flux<String> getDataUsingFlux() {
		return Flux
				.range(0, 25)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(e -> System.out.println("processing : "+ e))
				.map(e -> "\n<br>element "+e);
	}
}
