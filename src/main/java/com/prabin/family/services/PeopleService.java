package com.prabin.family.services;

import java.util.List;

import com.prabin.family.domain.People;

public interface PeopleService {
	
	//create
	void saveOnePeople(People people);
	
	//read
	List<People> findByFirstName(String lastName);
	
	//delete
	void deletePerson(People people);
}
