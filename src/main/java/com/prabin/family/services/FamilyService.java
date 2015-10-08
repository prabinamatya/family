package com.prabin.family.services;

import java.util.Collection;

import com.prabin.family.domain.People;

public interface FamilyService {
	
	void saveFamilyMember(People people);
	
	Collection<People> findByLastName(String lastName);

}
