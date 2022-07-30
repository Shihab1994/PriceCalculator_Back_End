package com.test.PriceCalculator.controller;

import com.test.PriceCalculator.model.Price;
import com.test.PriceCalculator.model.Product;
import com.test.PriceCalculator.service.PriceCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculator")
public class PriceCalculationController {

    @Autowired
    private PriceCalculationService service;

    @GetMapping("/productList")
    public List<Product> getProductList() {
        return service.getProductList();
    }

    @GetMapping("/priceList")
    public List<Price> getPriceList() {
        return service.getPriceList();
    }

    @GetMapping("/price")
    public Price getPriceById(@RequestParam int productId) {
        return service.getPriceById(productId);
    }

    @GetMapping("/totalPrice")
    public double getTotalProductPrice(@RequestParam int productId, @RequestParam int orderUnits) {
        return service.getPriceOfProduct(productId, orderUnits);
    }

}
