package com.app.src.prices.shared;

import com.app.src.prices.infra.database.serach.domain.BrandData;

public class ConstantTest {
    public static final Long ID = 100L;
    public static final Long ID_2 = 105L;
    public static final String DATE_TO_TEST = "2020-06-15-11.00.00";
    public static final Long BRAND_ID = 101L;
    public static final Long LOWER_PRIORITY = 0L;
    public static final Long HIGH_PRIORITY = 1L;

    public static final Double PRICE =  35.40;

    public static final BrandData BRAND = new BrandData() ;
    public static final Long PRICE_LIST = 100L;
    public static final Long PRODUCT_ID = 3594L;
    public static final String BRAND_NAME = "zara";
    public static final String WRONG_FORMAT_DATE = "2020-12-31 23.59.59";
}
