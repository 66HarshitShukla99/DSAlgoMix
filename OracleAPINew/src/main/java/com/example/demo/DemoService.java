package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DemoService{
	
	@Autowired
	private DemoRepository repo;
	
	public String validate(int id){
		
		return repo.validate(id);
	}
}
