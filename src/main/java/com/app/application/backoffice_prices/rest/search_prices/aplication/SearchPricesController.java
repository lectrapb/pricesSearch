package com.app.application.backoffice_prices.rest.search_prices.aplication;

import com.app.application.backoffice_prices.rest.search_prices.aplication.mapper.MapperPriceSearchRest;
import com.app.application.backoffice_prices.rest.search_prices.domain.ResponsePrice;
import com.app.application.backoffice_prices.rest.shared.domain.ConstantRestPath;
import com.app.src.prices_search.application.SearchPriceUseCase;
import com.app.src.prices_search.domain.search.model.PriceProductSearchReq;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class SearchPricesController {
    private final SearchPriceUseCase useCase;

    @GetMapping(ConstantRestPath.GET_PRICES)
    public ResponseEntity<ResponsePrice> searchPrice(@RequestParam() String dateToTest,
                                                     @RequestParam() Long idProduct,
                                                     @RequestParam() Long brandId){

        var result = useCase.searchByBrandAndDate(PriceProductSearchReq.builder()
                .dateToTest(dateToTest)
                .idProduct(idProduct)
                .brandId(brandId)
                .build());

        return ResponseEntity.status(HttpStatus.OK)
                .body(MapperPriceSearchRest.toResponse(result));
    }


}
