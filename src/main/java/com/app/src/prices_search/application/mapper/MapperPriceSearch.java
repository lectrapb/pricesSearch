package com.app.src.prices_search.application.mapper;


import com.app.src.prices_search.domain.search.model.PriceProductSearch;
import com.app.src.prices_search.domain.search.model.PriceProductSearchReq;
import com.app.src.prices_search.domain.value_object.DateData;
import com.app.src.prices_search.domain.value_object.IdData;
import com.app.src.shared.domain.BusinessException;
import com.app.src.shared.domain.ConstanSystemException;

public class MapperPriceSearch {
    public static PriceProductSearch toProductSerch(PriceProductSearchReq req) {

        if(req == null){
            throw new BusinessException(ConstanSystemException.REQUIRE_ARGUMENT);
        }
        return PriceProductSearch.builder()
                .brandId(new IdData(req.getBrandId()))
                .idProduct(new IdData(req.getIdProduct()))
                .dateToTest(new DateData(req.getDateToTest()))
                .build();


    }
}
