package com.app.src.prices_search.domain.search.gateway;



import com.app.src.prices_search.domain.search.model.PriceProduct;
import com.app.src.prices_search.domain.search.model.PriceProductSearch;

import java.util.List;

public interface SearchPrice {

    List<PriceProduct> findByIdAndDate(PriceProductSearch productSearch);
}
