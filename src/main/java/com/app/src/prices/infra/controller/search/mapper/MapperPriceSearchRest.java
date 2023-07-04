package com.app.src.prices.infra.controller.search.mapper;

import com.app.src.prices.infra.controller.search.domain.ResponsePrice;
import com.app.src.prices.infra.controller.search.domain.ResponsePriceData;
import com.app.src.prices.domain.search.model.PriceProduct;
import com.app.src.prices.shared.domain.BusinessConstant;

import java.text.SimpleDateFormat;

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
