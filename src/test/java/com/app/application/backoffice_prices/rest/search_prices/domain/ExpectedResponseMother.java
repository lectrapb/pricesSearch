package com.app.application.backoffice_prices.rest.search_prices.domain;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ExpectedResponseMother {

    public static final String REQ_URL_1 = "/api/search/prices?dateToTest=2020-06-14-10.00.00&idProduct=35455&brandId=1";
    public static final String REQ_URL_2 = "/api/search/prices?dateToTest=2020-06-14-16.00.00&idProduct=35455&brandId=1";
    public static final String REQ_URL_3 = "/api/search/prices?dateToTest=2020-06-14-21.00.00&idProduct=35455&brandId=1";
    public static final String REQ_URL_4 = "/api/search/prices?dateToTest=2020-06-15-10.00.00&idProduct=35455&brandId=1";
    public static final String REQ_URL_5 = "/api/search/prices?dateToTest=2020-06-16-21.00.00&idProduct=35455&brandId=1";

    private static final String resp1 = "{\n" +
            "        \"productId\": 35455,\n" +
            "        \"brandId\": 1,\n" +
            "        \"priceList\": 1,\n" +
            "        \"dateStart\": \"2020-06-14-00.00.00\",\n" +
            "        \"dateEnd\": \"2020-12-31-23.59.59\",\n" +
            "        \"price\": 35.5\n" +
            "    }";
    private static final String resp2 = "{\n" +
            "        \"productId\": 35455,\n" +
            "        \"brandId\": 1,\n" +
            "        \"priceList\": 2,\n" +
            "        \"dateStart\": \"2020-06-14-15.00.00\",\n" +
            "        \"dateEnd\": \"2020-06-14-18.30.00\",\n" +
            "        \"price\": 25.45\n" +
            "    }";
    private static final String resp3 = "{\n" +
            "        \"productId\": 35455,\n" +
            "        \"brandId\": 1,\n" +
            "        \"priceList\": 1,\n" +
            "        \"dateStart\": \"2020-06-14-00.00.00\",\n" +
            "        \"dateEnd\": \"2020-12-31-23.59.59\",\n" +
            "        \"price\": 35.5\n" +
            "    }";
    private static final String resp4 = "{\n" +
            "        \"productId\": 35455,\n" +
            "        \"brandId\": 1,\n" +
            "        \"priceList\": 3,\n" +
            "        \"dateStart\": \"2020-06-15-00.00.00\",\n" +
            "        \"dateEnd\": \"2020-06-15-11.00.00\",\n" +
            "        \"price\": 30.5\n" +
            "    }";
    private static final String resp5 = "{\n" +
            "        \"productId\": 35455,\n" +
            "        \"brandId\": 1,\n" +
            "        \"priceList\": 4,\n" +
            "        \"dateStart\": \"2020-06-15-16.00.00\",\n" +
            "        \"dateEnd\": \"2020-12-31-23.59.59\",\n" +
            "        \"price\": 38.95\n" +
            "    }";


    private static ResponsePrice getResponse(String json){

        Gson gson = new Gson();
        var expectedData = gson.fromJson( json, ResponsePriceData.class);
        return new ResponsePrice(expectedData);
    }

    private static Map<String, ResponsePrice> expectedResponse = new HashMap<>();

    static {

        expectedResponse.put(REQ_URL_1, getResponse(resp1));
        expectedResponse.put(REQ_URL_2, getResponse(resp2));
        expectedResponse.put(REQ_URL_3, getResponse(resp3));
        expectedResponse.put(REQ_URL_4, getResponse(resp4));
        expectedResponse.put(REQ_URL_5, getResponse(resp5));
    }

    public static ResponsePrice getExpectedResponse(String url ){

        return  expectedResponse.get(url);
    }



}
