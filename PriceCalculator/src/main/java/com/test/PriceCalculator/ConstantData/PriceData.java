package com.test.PriceCalculator.ConstantData;

import com.test.PriceCalculator.model.Price;
import com.test.PriceCalculator.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceData {

    public List<Price> getPriceList() {
        List<Price> priceList = new ArrayList<>();
        priceList.add(new Price(1, 175, 20));
        priceList.add(new Price(2, 825, 5));
        return priceList;
    }

    public Price getPriceByProductId(int productId) {
        List<Price> priceList = getPriceList();
        for (Price price : priceList) {
            if (price.getProductId() == productId)
                return price;
        }
        return null;
    }

}
