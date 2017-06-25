package demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping("/")
	public String hello() {
		return "Hello from Spring Boot";
	}
	
	@GetMapping("/about")
	public String hello2() {
		return "About";
	}
}
