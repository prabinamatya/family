package com.prabin.family.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prabin.family.FamilyApplication;
import com.prabin.family.domain.Family;
import com.prabin.family.domain.People;
import com.prabin.family.repository.FamilyRepository;
import com.prabin.family.repository.PeopleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FamilyApplication.class)
public class FamilyServiceImplTest {
	
	@Autowired
	PeopleRepository mockPeopleRepository;
	
	@Autowired
	FamilyRepository mockFamilyRepository;

	@Test
	public void testFindByLastName() {
		List<People> firstName = mockPeopleRepository.findByFirstName("prabin");
		Assert.assertEquals("Size", 1, firstName.size());
		Assert.assertEquals("Last Name ", "amatya", firstName.get(0).getFamilies().getLastName());
	}
	
	@Test
	@Ignore
	public void testSaveAFamily() throws Exception {
		Family family = new Family();
		family.setAddress("Scotland yar");
		family.setCity("London");
		family.setLastName("Clarkson");
		family.setZip(62221);
		family.setPeoples(createPeople());
		
		mockFamilyRepository.save(family);

		Iterable<Family> allFamily = mockFamilyRepository.findAll();
		Assert.assertEquals("Size", "London", allFamily.iterator().next().getCity());
	}
	
	public Set<People> createPeople() {
		Set<People> peopleSet = new HashSet<People>();
		People people = new People();
		people.setFirstName("Jeremy");
		peopleSet.add(people);
		return peopleSet;
	}

}
