package com.prabin.family.services;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.prabin.family.FamilyApplication;
import com.prabin.family.domain.Family;
import com.prabin.family.domain.People;
import com.prabin.family.repository.FamilyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FamilyApplication.class)
public class FamilyServiceImplTest {
	
	@Autowired
	FamilyRepository familyRepository;

	@Test
	@Transactional(readOnly = true)
	public void testfindAllPeopleByFamily() {
		
		Family familyLast = familyRepository.findOneByLastName("amatya");
		Set<People> peoples = familyLast.getPeoples();
		Assert.assertEquals("Number of People", 3, peoples.size());
		for (People people : peoples) {
			System.out.println(people.getFirstName());
		}
		
	}


}
