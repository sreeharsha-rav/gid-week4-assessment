package com.ordermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermicroservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
