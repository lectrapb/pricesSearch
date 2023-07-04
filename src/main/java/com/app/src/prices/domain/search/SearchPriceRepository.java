package com.app.src.prices.domain.search;



import com.app.src.prices.domain.search.model.PriceProduct;
import com.app.src.prices.domain.search.model.PriceProductSearch;

import java.util.List;

public interface SearchPriceRepository {

    List<PriceProduct> findByIdAndDate(PriceProductSearch productSearch);
}
