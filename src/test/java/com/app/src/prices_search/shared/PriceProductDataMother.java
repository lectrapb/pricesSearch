package com.app.src.prices_search.shared;

import com.app.src.prices_search.infra.database.serach.domain.BrandData;
import com.app.src.prices_search.infra.database.serach.domain.PriceProductData;
import com.app.src.prices_search.shared.ConstantTest;

import java.util.Date;

public class PriceProductDataMother {


    public static  PriceProductData getData() {

        var priceProductData = new PriceProductData();
        var brandData = new BrandData();
        brandData.setBrandId(ConstantTest.BRAND_ID);
        brandData.setName(ConstantTest.BRAND_NAME);
        priceProductData.setBrand(brandData);
        priceProductData.setStartDate(new Date());
        priceProductData.setEndDate(new Date());
        priceProductData.setPriceList(ConstantTest.PRICE_LIST);
        priceProductData.setProductId(ConstantTest.PRODUCT_ID);
        priceProductData.setPriority(ConstantTest.HIGH_PRIORITY);
        priceProductData.setPrice(ConstantTest.PRICE);
        return priceProductData;
    }
}
