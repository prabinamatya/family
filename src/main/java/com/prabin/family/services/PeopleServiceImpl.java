package com.prabin.family.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prabin.family.domain.People;
import com.prabin.family.repository.PeopleRepository;

@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;

	@Override
	public People saveOnePeople(People people) {
		return peopleRepository.save(people);
	}

	@Override
	public List<People> findByFirstName(String firstName) {
		return peopleRepository.findByFirstName(firstName);
	}

	@Override
	public void delete(Integer id) {
		peopleRepository.delete(id);
	}

	@Override
	public List<People> findAllPeople() {
		 return peopleRepository.findAll();
	}

}
