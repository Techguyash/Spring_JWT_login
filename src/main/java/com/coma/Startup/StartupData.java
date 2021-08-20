package com.coma.Startup;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.coma.Billing.Data.service.DiscountService;
import com.coma.Billing.Data.service.TaxService;
import com.coma.Entity.Discount;
import com.coma.Entity.Tax;
import com.coma.Repository.DiscountRepo;
import com.coma.Repository.TaxRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional(rollbackOn = SQLException.class)
public class StartupData {

    @Autowired
  TaxRepo taxRepo;

  @Autowired
  TaxService taxService;

    @Autowired
    DiscountRepo discountRepo;

    @Autowired
    DiscountService discountService;

    @PostConstruct
    private void init()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("-------TrackMe Application-------");
        System.out.println("Setting up default values on db");
        zeroDiscountData();
        zeroTaxData();
        System.out.println("Db fefault values set Successful");
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }

    private void zeroTaxData()
    {
        Tax tax= new Tax();
        tax.setCreatedAt(LocalDate.now());
        tax.setDescription("Default zero tax, System generated");
        tax.setId(0);
        tax.setPercentage(0);
        tax.setTaxName("Default Zero tax");
        tax.setEnabled(true);
        taxRepo.save(tax);
      
    }
    private void zeroDiscountData()
    {
        Discount discount= new Discount();
        discount.setCreatedAt(LocalDate.now());
        discount.setDescription("Default zero discount, System generated");
        discount.setId(0);
        discount.setDiscountName("Default zero discount");
        discount.setPercentageVal(0);
        discount.setEnabled(true);
        discountRepo.save(discount);
    }

    //TODO: add default retailer vendor
}
