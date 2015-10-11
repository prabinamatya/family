package com.prabin.family.services;

import java.util.Set;

import com.prabin.family.domain.People;

public interface FamilyService {
	
	Set<People> findAllPeopleByFamily(String lastName);

}
