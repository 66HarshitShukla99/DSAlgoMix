package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo{

	@Autowired
	private DemoService service;
	
	@GetMapping("/get/{id}")
	public String method(@PathVariable ("id") int id){ //"Success" or "Failed"
		return service.validate(id);
		
	}
	
}
