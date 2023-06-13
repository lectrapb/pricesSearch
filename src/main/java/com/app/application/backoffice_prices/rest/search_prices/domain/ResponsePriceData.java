package com.app.application.backoffice_prices.rest.search_prices.domain;

import lombok.Data;

@Data
public class ResponsePriceData {

    private Long productId;
    private Long brandId;
    private Long priceList;
    private String dateStart;
    private String dateEnd;
    private Double price;
}
