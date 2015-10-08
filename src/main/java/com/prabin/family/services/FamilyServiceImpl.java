package com.prabin.family.services;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prabin.family.domain.People;
import com.prabin.family.repository.PeopleRepository;


@Service
public class FamilyServiceImpl implements FamilyService {
	
	@Inject
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
