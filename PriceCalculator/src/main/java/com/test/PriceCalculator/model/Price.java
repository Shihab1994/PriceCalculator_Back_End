package com.test.PriceCalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    private int productId;

    private double pricePerCartoon;

    private int totalProductPerCartoon;

}
