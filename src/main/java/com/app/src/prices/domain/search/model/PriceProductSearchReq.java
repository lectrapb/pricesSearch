package com.app.src.prices.domain.search.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PriceProductSearchReq {
    private String dateToTest;
    private Long idProduct;
    private Long brandId;
}
