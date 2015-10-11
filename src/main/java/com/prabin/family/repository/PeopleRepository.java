package com.prabin.family.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prabin.family.domain.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, Integer>{
	
	List<People> findByFirstName(String firstName);
	
}
