package com.coma.Billing.Data.service;

import java.util.List;

import com.coma.Entity.Units;

public interface UnitService {

    Units createUnit(Units unit);
    List<Units> getAllUnits();
    Units getUnit(int id);
    boolean deleleUnit(int unitId);
    
}
