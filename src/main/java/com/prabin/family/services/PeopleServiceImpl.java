package com.prabin.family.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prabin.family.domain.People;
import com.prabin.family.repository.PeopleRepository;

@Service
@Component("familyService")
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;

	@Override
	@Transactional
	public void saveOnePeople(People people) {
		peopleRepository.save(people);
	}

	@Override
	@Transactional(readOnly = true)
	public List<People> findByFirstName(String firstName) {
		return peopleRepository.findByFirstName(firstName);
	}

	@Override
	@Transactional
	public void deletePerson(People people) {
		peopleRepository.delete(people);
	}

}
