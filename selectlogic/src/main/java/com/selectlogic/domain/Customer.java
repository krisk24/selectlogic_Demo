package com.selectlogic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id 
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	public Customer() {
	}

}
