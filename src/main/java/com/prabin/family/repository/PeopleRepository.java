package com.prabin.family.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabin.family.domain.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer>{
	
	List<People> findByFirstName(String firstName);
	
}
