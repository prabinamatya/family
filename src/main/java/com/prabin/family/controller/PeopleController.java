package com.prabin.family.controller;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prabin.family.domain.People;
import com.prabin.family.services.PeopleService;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleController.class);

	@Autowired
	private PeopleService peopleService;

	@RequestMapping("/test")
	@ResponseBody
	public String helloWorld() {
		return peopleService.findByFirstName("prabin").get(0).getFirstName();
	}
	
	@POST
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping("/new")
	public People create(@RequestBody People peopleEntry) {
		LOGGER.info("Creating a new people entry {}", peopleEntry);
		
		People created = peopleService.saveOnePeople(peopleEntry);
		LOGGER.info("Created a new people entry {}", created);
		
		return created;
	}
	
	@GET
	@RequestMapping("/allPeople")
	public List<People> getAllPeople() {
		LOGGER.info("finding all people");
		
		List<People> allPeople = peopleService.findAllPeople();
		LOGGER.info("Found {} all people", allPeople.size());

		return allPeople;
	}
	
	@PUT
	@RequestMapping(value = "/{id}/edit")
	public People updatePeople(@RequestBody People peopleEntry ) {
		LOGGER.info("Updating a people entry {}", peopleEntry);
		
		People updatedPeople = peopleService.saveOnePeople(peopleEntry);
		LOGGER.info("Updated a people entry {}", updatedPeople);

		return updatedPeople;
	}
	
	@DELETE
	@RequestMapping(value = "{id}")
	public void delete(@PathVariable("id") String id) {
		LOGGER.info("Deleting a  people entry with id {}", id);
		
		peopleService.delete(Integer.valueOf(id));
		LOGGER.info("Deleted a  people entry with id {}", id);
	}
}
