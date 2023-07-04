package com.app.src.prices.application;


import com.app.src.prices.application.mapper.MapperPriceSearch;
import com.app.src.prices.domain.search.SearchPriceRepository;
import com.app.src.prices.domain.search.model.PriceProduct;
import com.app.src.prices.domain.search.model.PriceProductSearchReq;
import com.app.src.prices.domain.exception.BusinessException;
import com.app.src.prices.domain.exception.ConstantBusinessException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SearchPrice {

    private final SearchPriceRepository searchPrice;

    public PriceProduct searchByBrandAndDate(PriceProductSearchReq req) {

        var prices = searchPrice.findByIdAndDate(MapperPriceSearch
                .toProductSerch(req));
        if (prices.isEmpty()) {
            throw new BusinessException(ConstantBusinessException.NOT_FOUND_DATA);
        }
        return prices.get(0);
    }
}
