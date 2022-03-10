package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class IndexController {
    
    private static final String template = "Hello %s, this index endpoint has %d hits!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/")
	public Index index(@RequestParam(value = "name", defaultValue = "World") String name) {
        counter.incrementAndGet();
		return new Index(counter.get(), String.format(template, name, counter.get()));
	}
}