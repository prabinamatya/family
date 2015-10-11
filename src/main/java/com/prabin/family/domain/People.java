package com.prabin.family.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jersey.repackaged.com.google.common.base.Objects;

@Entity
@Table(name = "people")
public class People {

	@Id
	@GeneratedValue
	private Integer people_id;

	@Column(name = "first_name")
	private String firstName;

	@ManyToOne
	@JoinColumn(name = "family_id")
	private Family famile;

	public Integer getPeople_id() {
		return people_id;
	}

	public void setPeople_id(Integer people_id) {
		this.people_id = people_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Family getFamilies() {
		return famile;
	}

	public void setFamilies(Family famile) {
		this.famile = famile;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(people_id, firstName, famile);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof People) {
			People that = (People) object;
			return Objects.equal(this.people_id, that.people_id)
					&& Objects.equal(this.firstName, that.firstName)
					&& Objects.equal(this.famile, that.famile);
		}
		return false;
	}

}
