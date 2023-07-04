package com.app.src.prices.domain.search.model;


import com.app.src.prices.domain.value.objects.DateData;
import com.app.src.prices.domain.value.objects.IdData;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceProductSearch {
    private DateData dateToTest;
    private IdData idProduct;
    private IdData brandId;
}
