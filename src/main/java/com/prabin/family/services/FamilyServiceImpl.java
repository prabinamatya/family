package com.prabin.family.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prabin.family.domain.Family;
import com.prabin.family.domain.People;
import com.prabin.family.repository.FamilyRepository;

@Service
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	FamilyRepository familyRepository;

	@Override
	@Transactional(readOnly = true)
	public Set<People> findAllPeopleByFamilyLastName(String lastName) {
		Family family = familyRepository.findOneByLastName(lastName);
		return family.getPeoples();
	}
}
