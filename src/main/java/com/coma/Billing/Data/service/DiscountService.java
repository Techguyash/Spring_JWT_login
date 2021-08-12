package com.coma.Billing.Data.service;

import java.util.List;

import com.coma.Billing.Data.model.CreateDiscountRequest;
import com.coma.Entity.Discount;

public interface DiscountService {

    Discount createDiscount(CreateDiscountRequest req);
    Discount getDiscount(int id);
    List<Discount> getAllDiscounts();
    Discount updateDiscount(Discount discount);
    boolean deleteDiscount(int Id);
}
