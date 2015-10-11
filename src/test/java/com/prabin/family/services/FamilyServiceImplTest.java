package com.prabin.family.services;

import java.util.Arrays;
import java.util.HashSet;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FamilyApplication.class)
@Transactional
public class FamilyServiceImplTest {
	
//	@Mock
//	FamilyRepository mockFamilyRepository;
//	
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
	
	@Autowired
	FamilyRepository familyRepository;

	@Test
	public void testfindAllPeopleByFamily() {
		
//		Family mockFamily = createFamily();
//		Mockito.when(mockFamilyRepository.findOneByLastName(Mockito.any(String.class))).thenReturn(mockFamily);
//		
//		Family familyWithLastName = mockFamilyRepository.findOneByLastName("Scott");
//		Set<People> peoples = familyWithLastName.getPeoples();
		
//		Assert.assertEquals("Number of People", 3, peoples.size());
		
		Family familyLast = familyRepository.findOneByLastName("amatya");
		Set<People> peoples = familyLast.getPeoples();
		Assert.assertEquals("Number of People", 3, peoples.size());
		
	}

	private Family createFamily() {
		Family family = new Family();
		family.setCity("Chicago");
		family.setFamilyId(2000);
		family.setLastName("Scott");
		family.setPeoples(createPeoples());
		family.setState("IL");
		family.setZip(60618);
		return family;
	}

	private Set<People> createPeoples() {
		
		Set<People> peoples = new HashSet<People>();
		
		People people1 = new People();
		people1.setFirstName("Rob");
		people1.setPeople_id(3000);
		
		People people2 = new People();
		people2.setFirstName("Thomas");
		people2.setPeople_id(3000);

		People people3 = new People();
		people3.setFirstName("Meg");
		people3.setPeople_id(3000);
		
		peoples.addAll(Arrays.asList(people1, people2, people3));
		
		return peoples;
	}

}
