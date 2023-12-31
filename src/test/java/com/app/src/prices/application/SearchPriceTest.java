package com.app.src.prices.application;

import com.app.src.prices.shared.ConstantTest;
import com.app.src.prices.domain.search.SearchPriceRepository;
import com.app.src.prices.domain.search.model.PriceProduct;
import com.app.src.prices.domain.search.model.PriceProductSearchReq;
import com.app.src.prices.domain.exception.BusinessException;
import com.app.src.prices.domain.exception.ConstantBusinessException;
import com.app.src.prices.domain.exception.ConstanSystemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchPriceTest {


    private SearchPriceRepository searchPrice;
    private SearchPrice useCase;

    @BeforeEach
    void setUp() {
        this.searchPrice = mock(SearchPriceRepository.class);
        this.useCase = new SearchPrice(searchPrice);
    }

    @Test
    void search_price_null_test() {
        //given
        //when
        var exception = assertThrows(BusinessException.class, () -> {
            useCase.searchByBrandAndDate(null);
        });
        //then
        assertEquals(exception.getMessage(), ConstanSystemException.REQUIRE_ARGUMENT.getCode());
    }

    @Test
    void search_price_empty_list_prices_test() {
        //given
        var request = PriceProductSearchReq.builder()
                .idProduct(ConstantTest.ID)
                .dateToTest(ConstantTest.DATE_TO_TEST)
                .brandId(ConstantTest.BRAND_ID)
                .build();
        var prices = new ArrayList<PriceProduct>();
        //when
        when(searchPrice.findByIdAndDate(any())).thenReturn(prices);
        var exception = assertThrows(BusinessException.class, () -> {
            useCase.searchByBrandAndDate(request);
        });
        //then
        assertEquals(exception.getMessage(), ConstantBusinessException.NOT_FOUND_DATA
                .getCode());
    }

    @Test
    void search_price_single_list_prices_test() {
        //given
        var request = PriceProductSearchReq.builder()
                .idProduct(ConstantTest.ID)
                .dateToTest(ConstantTest.DATE_TO_TEST)
                .brandId(ConstantTest.BRAND_ID)
                .build();
        var prices = new ArrayList<PriceProduct>();
        prices.add(PriceProduct.builder().build());
        //when
        when(searchPrice.findByIdAndDate(any())).thenReturn(prices);
        var response = useCase.searchByBrandAndDate(request);
        //then
        assertInstanceOf(PriceProduct.class, response);
    }

    @Test
    void search_price_priority_search_list_prices_test() {
        //given
        var request = PriceProductSearchReq.builder()
                .idProduct(ConstantTest.ID)
                .dateToTest(ConstantTest.DATE_TO_TEST)
                .brandId(ConstantTest.BRAND_ID)
                .build();
        var prices = new ArrayList<PriceProduct>();
        prices.add(PriceProduct.builder()
                .priority(ConstantTest.HIGH_PRIORITY)
                .build());
        prices.add(PriceProduct.builder()
                .priority(ConstantTest.LOWER_PRIORITY)
                .build());

        //when
        when(searchPrice.findByIdAndDate(any())).thenReturn(prices);
        var response = useCase.searchByBrandAndDate(request);
        //then
        assertEquals(response.getPriority(), ConstantTest.HIGH_PRIORITY);
    }

}