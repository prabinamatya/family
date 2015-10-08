package com.prabin.family.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prabin.family.services.FamilyService;

@Controller
public class PeopleController {
	
	@Autowired
	private FamilyService familyService;

	@RequestMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	public String helloWorld() {
		return familyService.findByLastName("Amatya").get(0).getFirstName();
	}
}
