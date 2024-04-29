package com.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.entities.Orders;

public interface velaRepo extends JpaRepository<Orders,Integer>{

    
} 
