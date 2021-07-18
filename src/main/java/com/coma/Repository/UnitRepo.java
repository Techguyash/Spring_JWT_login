package com.coma.Repository;

import com.coma.Entity.Units;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepo extends JpaRepository<Units,Integer>
{
    
}
