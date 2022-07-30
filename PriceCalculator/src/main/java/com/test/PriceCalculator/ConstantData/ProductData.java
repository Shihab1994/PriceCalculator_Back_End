package com.test.PriceCalculator.ConstantData;

import com.test.PriceCalculator.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductData {

    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Penguin-ears"));
        productList.add(new Product(2, "Horseshoe"));
        return productList;
    }

    public Product getProductById(int productId) {
        List<Product> productList = getProductList();
        for (Product product : productList) {
            if (product.getProductId() == productId)
                return product;
        }
        return null;
    }

}
