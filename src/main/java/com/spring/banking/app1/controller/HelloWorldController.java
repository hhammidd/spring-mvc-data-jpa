package com.spring.banking.app1.controller;

import com.spring.banking.app1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloWorldController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/")
	public String home() {
		return "test";
	}

}