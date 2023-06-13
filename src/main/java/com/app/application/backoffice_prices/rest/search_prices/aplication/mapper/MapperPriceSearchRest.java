package com.app.application.backoffice_prices.rest.search_prices.aplication.mapper;

import com.app.application.backoffice_prices.rest.search_prices.domain.ResponsePrice;
import com.app.application.backoffice_prices.rest.search_prices.domain.ResponsePriceData;
import com.app.src.prices_search.domain.search.model.PriceProduct;
import com.app.src.prices_search.shared.domain.BusinessConstant;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class MapperPriceSearchRest {
    public static ResponsePrice toResponse(PriceProduct result) {

        SimpleDateFormat formatter = new SimpleDateFormat(BusinessConstant.FORMAT_DATE);
        ResponsePriceData responsePrice = new ResponsePriceData();
        responsePrice.setProductId(result.getProductId());
        responsePrice.setBrandId(result.getBrandId());
        responsePrice.setPriceList(result.getPriceList());
        responsePrice.setDateStart(formatter.format(result.getStartDate()));
        responsePrice.setDateEnd(formatter.format(result.getEndDate()));
        responsePrice.setPrice(result.getPrice());

        return new ResponsePrice(responsePrice);
    }
}
