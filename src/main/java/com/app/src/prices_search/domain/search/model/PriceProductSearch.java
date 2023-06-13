package com.app.src.prices_search.domain.search.model;


import com.app.src.prices_search.domain.value_object.DateData;
import com.app.src.prices_search.domain.value_object.IdData;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceProductSearch {
    private DateData dateToTest;
    private IdData idProduct;
    private IdData brandId;
}
