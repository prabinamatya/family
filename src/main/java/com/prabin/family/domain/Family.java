package com.prabin.family.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jersey.repackaged.com.google.common.base.Objects;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "family")
public class Family {

	@Id
	@GeneratedValue
	private Integer familyId;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zip")
	private Integer zip;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "famile")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "famile", orphanRemoval = true)
	private Set<People> peoples;
	
	public Integer getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	@Transactional
	public Set<People> getPeoples() {
		return peoples;
	}

	public void setPeoples(Set<People> peoples) {
		this.peoples = peoples;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(familyId, lastName, address, city, state, zip,
				peoples);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Family) {
			Family that = (Family) object;
			return Objects.equal(this.familyId, that.familyId)
					&& Objects.equal(this.lastName, that.lastName)
					&& Objects.equal(this.address, that.address)
					&& Objects.equal(this.city, that.city)
					&& Objects.equal(this.state, that.state)
					&& Objects.equal(this.zip, that.zip)
					&& Objects.equal(this.peoples, that.peoples);
		}
		return false;
	}

}
