package com.selectlogic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selectlogic.domain.Team;
import com.selectlogic.domain.Teammate;
import com.selectlogic.repositories.TeamRepository;
import com.selectlogic.repositories.TeammateRepository;

@Service
public class DatabaseLoader {
	
	private final TeammateRepository teammateRepository;
	private final TeamRepository teamRepository;
	
	@Autowired
	public DatabaseLoader(TeammateRepository teammateRepository,
	TeamRepository teamRepository) {
		this.teammateRepository = teammateRepository;
		this.teamRepository = teamRepository;
	}
	
	@PostConstruct
	private void initDatabase() {
		Team springBootTeam = new Team("Spring Boot Badgers");
		teamRepository.save(springBootTeam);
		
		Team springBootTeam2 = new Team("Spring Boot Rangers");
		teamRepository.save(springBootTeam2);
	
		Teammate greg = new Teammate("Greg", "Turnquist");
		greg.setPosition("2nd base");
		greg.setTeam(springBootTeam);
		teammateRepository.save(greg);
	
		Teammate roy = new Teammate("Roy", "Clarkson");
		roy.setPosition("1st base");
		roy.setTeam(springBootTeam2);
		teammateRepository.save(roy);
	
		Teammate phil = new Teammate("Phil", "Webb");
		phil.setPosition("pitcher");
		phil.setTeam(springBootTeam2);
		teammateRepository.save(phil);
	}
	
	

}
