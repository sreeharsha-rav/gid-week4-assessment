package com.customermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customermicroservice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
