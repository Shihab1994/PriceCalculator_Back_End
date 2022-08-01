package com.test.PriceCalculator.controller;

import com.test.PriceCalculator.model.Price;
import com.test.PriceCalculator.model.Product;
import com.test.PriceCalculator.service.PriceCalculationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculator")
@Api(tags = "Price Calculator")
public class PriceCalculationController {

    @Autowired
    private PriceCalculationService service;

    @GetMapping("/productList")
    @ApiOperation(value = "product list", response = Product.class)
    public List<Product> getProductList() {
        return service.getProductList();
    }

    @GetMapping("/priceList")
    @ApiOperation(value = "price list", response = Price.class)
    public List<Price> getPriceList() {
        return service.getPriceList();
    }

    @GetMapping("/price")
    @ApiOperation(value = "product price", response = Price.class)
    public Price getPriceById(@RequestParam int productId) {
        return service.getPriceById(productId);
    }

    @GetMapping("/totalPrice")
    @ApiOperation(value = "Total price", response = Double.class)
    public double getTotalProductPrice(@RequestParam int productId, @RequestParam int orderUnits) {
        return service.getPriceOfProduct(productId, orderUnits);
    }

}
