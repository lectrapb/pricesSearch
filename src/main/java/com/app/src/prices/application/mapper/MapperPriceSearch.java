package com.app.src.prices.application.mapper;


import com.app.src.prices.domain.search.model.PriceProductSearch;
import com.app.src.prices.domain.search.model.PriceProductSearchReq;
import com.app.src.prices.domain.value.objects.DateData;
import com.app.src.prices.domain.value.objects.IdData;
import com.app.src.prices.domain.exception.BusinessException;
import com.app.src.prices.domain.exception.ConstanSystemException;

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
