package com.qa.kittens.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.kittens.data.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Long> {

}
