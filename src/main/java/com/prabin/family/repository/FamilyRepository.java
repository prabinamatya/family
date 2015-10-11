package com.prabin.family.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prabin.family.domain.Family;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Integer>{
	
	Family findOneByLastName(String lastName);

}
