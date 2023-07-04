package com.app.src.prices.infra.database.serach.aplication;


import com.app.src.prices.domain.search.SearchPriceRepository;
import com.app.src.prices.domain.search.model.PriceProduct;
import com.app.src.prices.domain.search.model.PriceProductSearch;
import com.app.src.prices.infra.database.serach.aplication.mapper.MapperPriceSearchData;
import com.app.src.prices.infra.database.serach.domain.PriceProductData;
import com.app.src.prices.infra.database.serach.infra.PriceRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SearchPricesAdapter implements SearchPriceRepository {

    private final PriceRepositoryJpa priceRepository;
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
