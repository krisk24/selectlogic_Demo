package com.selectlogic.domain;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teammate> getMembers() {
		return members;
	}

	public void setMembers(List<Teammate> members) {
		this.members = members;
	}

	@OneToMany(mappedBy = "team")
	private List<Teammate> members;
	
	private Team() {
		members = new ArrayList<>();
	}
	
	public Team(String name) {
		this();
		this.name = name;
	}
	
	

}
