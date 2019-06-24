package com.industryBuyingAssignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/{path}")
	public String importToMysql(@PathVariable("path") String path) {
		return "Success";
	}
}
