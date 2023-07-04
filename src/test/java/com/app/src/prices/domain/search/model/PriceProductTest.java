package com.app.src.prices.domain.search.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceProductTest {
    @Test
    void create_test(){
        var priceProduct = new PriceProduct();
        assertNotNull(priceProduct);
    }

}