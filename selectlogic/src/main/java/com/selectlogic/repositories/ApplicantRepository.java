package com.selectlogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selectlogic.domain.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

}
