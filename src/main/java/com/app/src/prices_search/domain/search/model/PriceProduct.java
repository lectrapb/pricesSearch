package com.app.src.prices_search.domain.search.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PriceProduct {



    private Long productId;
    private Long brandId;
    private Long priceList;
    private Date startDate;
    private Date endDate;
    private Double price;
    private Long priority;

}
