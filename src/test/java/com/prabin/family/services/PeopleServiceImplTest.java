package com.prabin.family.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Assert;
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
@Transactional
public class PeopleServiceImplTest {
	
	@Autowired
	PeopleRepository peopleRepository;
	
	@Autowired
	FamilyRepository familyRepository;

	//Read Test
	@Test
	public void testFindByFirstName() {
		List<People> firstName = peopleRepository.findByFirstName("prabin");
		Assert.assertEquals("Size", 1, firstName.size());
		Assert.assertEquals("Last Name ", "amatya", firstName.get(0).getFamilies().getLastName());
	}
	
	//Create & Save Family & people
	@Test
	public void testSaveAFamily() throws Exception {
		Family family = new Family();
		family.setAddress("Scotland yar");
		family.setCity("London");
		family.setLastName("Clarkson");
		family.setZip(62221);
		family.setPeoples(createPeople());
		
		familyRepository.save(family);

		Assert.assertEquals("Size", 3, familyRepository.count());
	}
	
	//update people
	@Test
	public void testUpdatePeople() throws Exception {
		
		People updatePeople = peopleRepository.findOne(1002);
		Assert.assertEquals("FirstName Test", "ben", updatePeople.getFirstName() );
		
		
		updatePeople.setFirstName("NewBen");
		peopleRepository.save(updatePeople);
		
		
		People updatedNewPeople = peopleRepository.findOne(1002);
		Assert.assertEquals("FirstName Test", "NewBen", updatedNewPeople.getFirstName() );
		
	}
	
	//Delete
	@Test
	public void testDeleteAFamilyMember() throws Exception {
		People peopleOne = peopleRepository.findOne(1000);
		Assert.assertEquals("First Name Access", "prabin", peopleOne.getFirstName());

		peopleRepository.delete(peopleOne);
		
		Assert.assertNull(peopleRepository.findOne(1000));
		
		
	}
	
	public Set<People> createPeople() {
		Set<People> peopleSet = new HashSet<People>();
		People people = new People();
		people.setFirstName("Jeremy");
		peopleSet.add(people);
		return peopleSet;
	}

}
