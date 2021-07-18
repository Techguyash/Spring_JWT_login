package com.coma.Billing.Data.service;

import com.coma.Entity.Units;
import com.coma.Repository.UnitRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService_Impl implements UnitService {

  @Autowired
  UnitRepo repo;

  @Override
  public Units createUnit(Units unit) {
    // TODO save unit method stub

    try {
      List<Units> allUnit = repo.findAll();
      for(Units singleUnit : allUnit)
      {
          if(singleUnit.getShortForm().equalsIgnoreCase(unit.getShortForm()))
          {
            throw new Exception("Already available");
          }
      }

      return repo.save(unit);
     
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Units> getAllUnits() {
    // TODO Auto-generated method stub
    try {
      return repo.findAll();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean deleleUnit(int unitId) {
    // TODO Auto-generated method stub
    try {
      repo.deleteById(unitId);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public Units getUnit(int id) {
   return repo.getById(id);
   
  }
}
