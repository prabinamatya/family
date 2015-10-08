package com.prabin.family.services;

import java.util.List;

import com.prabin.family.domain.People;

public interface FamilyService {
	
	void saveFamilyMember(People people);
	
	List<People> findByLastName(String lastName);

}
