package com.app.src.prices.infra.controller.search;

import com.app.src.prices.infra.controller.search.mapper.MapperPriceSearchRest;
import com.app.src.prices.infra.controller.search.domain.ResponsePrice;
import com.app.src.prices.infra.controller.shared.domain.ConstantRestPath;
import com.app.src.prices.application.SearchPrice;
import com.app.src.prices.domain.search.model.PriceProductSearchReq;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SearchPricesController {
    private final SearchPrice useCase;

    @GetMapping(ConstantRestPath.GET_PRICES)
    public ResponseEntity<ResponsePrice> searchPrice(@RequestParam() String dateToTest,
                                                     @RequestParam() Long idProduct,
                                                     @RequestParam() Long brandId){

        return ResponseEntity.status(HttpStatus.OK)
                .body(MapperPriceSearchRest.toResponse(useCase
                        .searchByBrandAndDate(PriceProductSearchReq.builder()
                        .dateToTest(dateToTest)
                        .idProduct(idProduct)
                        .brandId(brandId)
                        .build())));
    }


}
