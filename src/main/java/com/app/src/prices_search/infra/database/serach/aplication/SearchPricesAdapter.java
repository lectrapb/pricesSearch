package com.app.src.prices_search.infra.database.serach.aplication;


import com.app.src.prices_search.domain.search.gateway.SearchPrice;
import com.app.src.prices_search.domain.search.model.PriceProduct;
import com.app.src.prices_search.domain.search.model.PriceProductSearch;
import com.app.src.prices_search.infra.database.serach.aplication.mapper.MapperPriceSearchData;
import com.app.src.prices_search.infra.database.serach.domain.PriceProductData;
import com.app.src.prices_search.infra.database.serach.infra.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SearchPricesAdapter implements SearchPrice {

    private final PriceRepository priceRepository;
    @Override
    public List<PriceProduct> findByIdAndDate(PriceProductSearch productSearch) {
        var dateToSearch = productSearch.getDateToTest().getValue();
        var idProduct = productSearch.getIdProduct().getValue();
        var brandId = productSearch.getBrandId().getValue();

        List<PriceProductData> pricesData = priceRepository
                .searchPrice(dateToSearch, idProduct, brandId);
        return MapperPriceSearchData.toModel(pricesData);

    }
}
