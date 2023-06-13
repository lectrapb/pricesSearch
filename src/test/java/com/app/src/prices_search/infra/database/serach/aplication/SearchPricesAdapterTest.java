package com.app.src.prices_search.infra.database.serach.aplication;

import com.app.src.prices_search.shared.ConstantTest;
import com.app.src.prices_search.shared.PriceProductDataMother;
import com.app.src.prices_search.domain.search.model.PriceProductSearch;
import com.app.src.prices_search.domain.value_object.DateData;
import com.app.src.prices_search.domain.value_object.IdData;
import com.app.src.prices_search.infra.database.serach.domain.PriceProductData;
import com.app.src.prices_search.infra.database.serach.infra.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchPricesAdapterTest {


    private PriceRepository priceRepository;
    private SearchPricesAdapter adapter;

    @BeforeEach
    void setUp() {
        this.priceRepository = mock(PriceRepository.class);
        this.adapter = new SearchPricesAdapter(priceRepository);
    }

    @Test
    void find_by_id_and_date_ok_test() {

        //given
        var req = PriceProductSearch.builder()
                .dateToTest(new DateData(ConstantTest.DATE_TO_TEST))
                .idProduct(new IdData(ConstantTest.PRODUCT_ID))
                .brandId(new IdData(ConstantTest.BRAND_ID))
                .build();
        PriceProductData[] data = {PriceProductDataMother.getData(),
                PriceProductDataMother.getData()};
        var responseRepository = Arrays.asList(data);
        //when
        when(priceRepository.searchPrice(any(), any(), any()))
                .thenReturn(responseRepository);
        var result = adapter.findByIdAndDate(req);
        //then
        assertNotNull(result);

    }


}