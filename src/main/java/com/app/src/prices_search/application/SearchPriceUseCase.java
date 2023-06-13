package com.app.src.prices_search.application;


import com.app.src.prices_search.application.mapper.MapperPriceSearch;
import com.app.src.prices_search.domain.search.gateway.SearchPrice;
import com.app.src.prices_search.domain.search.model.PriceProduct;
import com.app.src.prices_search.domain.search.model.PriceProductSearchReq;
import com.app.src.shared.domain.BusinessException;
import com.app.src.shared.domain.ConstanBusinessException;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class SearchPriceUseCase {

    private final SearchPrice searchPrice;

    public PriceProduct searchByBrandAndDate(PriceProductSearchReq req) {

        var productSearch = MapperPriceSearch.toProductSerch(req);
        List<PriceProduct> prices = searchPrice.findByIdAndDate(productSearch);
        if (prices.isEmpty()) {
            throw new BusinessException(ConstanBusinessException.NOT_FOUND_DATA);
        }
        return prices.get(0);
    }
}
