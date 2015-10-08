package com.prabin.family.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import jersey.repackaged.com.google.common.base.Objects;

@Entity
public class People {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		People people = (People) o;
		return Objects.equal(firstName, people.firstName) && 
				Objects.equal(lastName, people.lastName) &&
				Objects.equal(address, people.address);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(firstName, lastName, address);
	}
}
