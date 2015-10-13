package com.prabin.family.controller;


import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prabin.family.services.PeopleService;

@Controller
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;

	@RequestMapping("/")
	@ResponseBody
	public String helloWorld() {
		return peopleService.findByFirstName("prabin").get(0).getFirstName();
	}
	
	@GET
	@RequestMapping("/people/allPeople")
	public void getAllPeople() {
	}
	
	public void updatePeople() {
		
	}
}
