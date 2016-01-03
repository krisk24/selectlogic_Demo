package com.selectlogic;



import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.selectlogic.domain.Teammate;
import com.selectlogic.repositories.CustomerRepository;
import com.selectlogic.repositories.TeammateRepository;


@SpringBootApplication
public class SelectlogicApplication {
	
	private static final Logger log =
			LoggerFactory.getLogger(SelectlogicApplication.class);
	
	
    public static void main(String[] args) {
        SpringApplication.run(SelectlogicApplication.class, args);
    }
    
    @Autowired
    DatabaseLoader databaseLoader;
    
    @Autowired
    TeammateRepository teammateRepository;
    
    @Autowired
    CustomerRepository customerRepository;
    
    @PostConstruct
    void seeTheRoster() {
    	for (Teammate teammate : teammateRepository.findAll()) {
    		log.info(teammate.toString());
    	}
    }
    
    
    @Bean
    InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

        return new InitializingBean() {
            public void afterPropertiesSet() throws Exception {

                Group group = identityService.newGroup("user");
                group.setName("users");
                group.setType("security-role");
                identityService.saveGroup(group);

                User admin = identityService.newUser("admin");
                admin.setPassword("admin");
                identityService.saveUser(admin);

            }
        };
    
    }
}
