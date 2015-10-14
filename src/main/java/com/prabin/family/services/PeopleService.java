package com.prabin.family.services;

import java.util.List;

import com.prabin.family.domain.People;

public interface PeopleService {
	
	//create & save
	People saveOnePeople(People people);
	
	//read
	List<People> findByFirstName(String lastName);
	
	//delete
	void delete(Integer id);
	
	//read
	List<People> findAllPeople();
	
}
