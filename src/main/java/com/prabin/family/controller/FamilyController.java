package com.prabin.family.controller;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prabin.family.domain.People;
import com.prabin.family.services.FamilyService;

@Controller
public class FamilyController {
	
	@Autowired
	private FamilyService familyService;
	
	@GET
	@RequestMapping("/family/allpeople/{lastName}")
	@Produces(MediaType.APPLICATION_XML)
	@ResponseBody
//	public @ResponseBody Set<People> groupPeopleByFamily(@PathVariable("lastName") String lastName) {
	public Set<People> groupPeopleByFamily(@PathVariable("lastName") String lastName) {
		Set<People> findAllPeopleByFamilyLastName = familyService.findAllPeopleByFamilyLastName(lastName);
		return findAllPeopleByFamilyLastName;
	}

}
