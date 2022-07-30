package com.test.PriceCalculator.service;

import com.test.PriceCalculator.ConstantData.PriceData;
import com.test.PriceCalculator.ConstantData.ProductData;
import com.test.PriceCalculator.model.Price;
import com.test.PriceCalculator.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {

    @Autowired
    private ProductData productData;
    @Autowired
    private PriceData priceData;

    @Override
    public List<Product> getProductList() {
        return productData.getProductList();
    }

    @Override
    public List<Price> getPriceList() {
        return priceData.getPriceList();
    }

    @Override
    public Product getProductById(int productId) {
        return productData.getProductById(productId);
    }

    @Override
    public Price getPriceById(int productId) {
        return priceData.getPriceByProductId(productId);
    }

    @Override
    public double getPriceOfProduct(int productId, int orderUnits) {
        Price price = getPriceById(productId);
        double perCartoonPrice = price.getPricePerCartoon();
        double totalUnitsPerCartoon = price.getTotalProductPerCartoon();
        double pricePerUnit = perCartoonPrice / totalUnitsPerCartoon;
        double totalCartoonOrder = orderUnits / totalUnitsPerCartoon;
        System.out.println("totalCartoonOrder: " + totalCartoonOrder);
        if(totalCartoonOrder >= 3){
            return priceWithDiscount(pricePerUnit, orderUnits, 10);
        }
        if(orderUnits == 1){
            return priceWithDiscount(pricePerUnit, orderUnits, -30);
        }
        return pricePerUnit * orderUnits;
    }

    private double priceWithDiscount(double pricePerUnit, int orderUnits, int discount){
        System.out.println("pricePerUnit: " + pricePerUnit);
        System.out.println("orderUnits: " + orderUnits);
        System.out.println("discount: " + discount);
        return (pricePerUnit * orderUnits) - (((pricePerUnit * orderUnits)/100.0)*discount);
    }
}
