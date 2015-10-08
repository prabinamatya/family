package com.prabin.family.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.prabin.family.domain.People;
import com.prabin.family.repository.PeopleRepository;

@Component("familyService")
public class FamilyServiceImpl implements FamilyService {
	
	@Autowired
	private PeopleRepository peopleRepository;

	@Override
	public void saveFamilyMember(People people) {
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<People> findByLastName(String lastName) {
		return peopleRepository.findByLastName(lastName);
	}

}
