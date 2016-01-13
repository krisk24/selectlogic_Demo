package com.selectlogic.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.selectlogic.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, QueryDslPredicateExecutor<Customer> {

}

