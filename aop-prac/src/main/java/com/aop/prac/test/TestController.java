package com.aop.prac.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/index")
	public String index() {
		System.out.println("=======메서드 진입=======");
		return "Hello World";
	}

}
