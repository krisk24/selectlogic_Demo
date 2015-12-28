package com.selectlogic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Teammate {
	
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String firstName;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	private String lastName;
	private String position;
	
	@ManyToOne
	private Team team;
	
	public Teammate() {
		
	}
	
	public Teammate(String firstName, String lastName) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	@Override
	public String toString() {
		return "Teammate [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", position=" + position
				+ ", getTeam()=" + getTeam() + "]";
	}
	
	
	
	
	

}
