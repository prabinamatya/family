package com.prabin.family.controller;

import java.util.Set;

import javax.ws.rs.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prabin.family.domain.People;
import com.prabin.family.services.FamilyService;

@RestController
public class FamilyController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(FamilyController.class);
	
	@Autowired
	private FamilyService familyService;
	
	@GET
	@RequestMapping("/api/family/allpeople/{lastName}")
	@ResponseBody
	public Set<People> groupPeopleByFamily(@PathVariable("lastName") String lastName) {
        LOGGER.info("Finding group of people in family by last name: {}", lastName);

		Set<People> findAllPeopleByFamilyLastName = familyService.findAllPeopleByFamilyLastName(lastName);
		
		LOGGER.info("Found group of people in family by last name: {}", lastName);
		return findAllPeopleByFamilyLastName;
	}

}

