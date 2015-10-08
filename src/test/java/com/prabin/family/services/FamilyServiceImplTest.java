package com.prabin.family.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prabin.family.FamilyApplication;
import com.prabin.family.domain.People;
import com.prabin.family.repository.PeopleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FamilyApplication.class)
public class FamilyServiceImplTest {
	
	@Autowired
	PeopleRepository mockPeopleRepository;

	@Test
	@Ignore
	public void testSaveFamilyMember() {
//		fail("Not yet implemented");
	}

	@Test
	public void testFindByLastName() {
		List<People> lastName = mockPeopleRepository.findByLastName("Amatya");
		Assert.assertEquals("Passed", 1, lastName.size());
		Assert.assertEquals("First Name ", "Prabin", lastName.get(0).getFirstName());
	}

}
