package com.app.src.prices.infra.database.serach.aplication.mapper;



import com.app.src.prices.domain.search.model.PriceProduct;
import com.app.src.prices.infra.database.serach.domain.PriceProductData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapperPriceSearchData {
    public static List<PriceProduct> toModel(List<PriceProductData> pricesData) {


        return Optional.of(pricesData
                        .stream()
                        .map(MapperPriceSearchData::getBuildData)
                        .collect(Collectors.toList()))
                .filter(l -> !l.isEmpty())
                .orElse(new ArrayList<PriceProduct>());

    }

    private static PriceProduct getBuildData(PriceProductData priceData) {
        return PriceProduct.builder()
                .productId(priceData.getProductId())
                .brandId(priceData.getBrand().getBrandId())
                .priceList(priceData.getPriceList())
                .startDate(priceData.getStartDate())
                .endDate(priceData.getEndDate())
                .price(priceData.getPrice())
                .priority(priceData.getPriority())
                .build();
    }
}
