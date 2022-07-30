package com.test.PriceCalculator.service;

import com.test.PriceCalculator.model.Price;
import com.test.PriceCalculator.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PriceCalculationService {


    List<Product> getProductList();

    List<Price> getPriceList();

    public Product getProductById(int productId);

    public Price getPriceById(int productId);

    public double getPriceOfProduct(int productId, int totalUnits);
}
