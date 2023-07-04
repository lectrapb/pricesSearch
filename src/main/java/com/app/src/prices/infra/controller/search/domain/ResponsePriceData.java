package com.app.src.prices.infra.controller.search.domain;

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
