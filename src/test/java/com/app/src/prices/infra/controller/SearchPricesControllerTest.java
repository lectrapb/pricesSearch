package com.app.src.prices.infra.controller;

import com.app.src.prices.infra.controller.search.domain.ResponsePrice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static com.app.src.prices.infra.controller.domain.ExpectedResponseMother.*;
import static com.app.src.prices.infra.controller.domain.ExpectedResponseMother.getExpectedResponse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchPricesControllerTest {


    @Autowired
    private TestRestTemplate template;
    @ParameterizedTest
    @ValueSource(strings = {REQ_URL_1, REQ_URL_2, REQ_URL_3, REQ_URL_4, REQ_URL_5})
    void searchPrice(String url) {
        //given
        var expectedResponse = getExpectedResponse(url);
        //when
        ResponseEntity<ResponsePrice> response = template.getForEntity(url, ResponsePrice.class);
        //then
        assertTrue(compareResponse(expectedResponse, response.getBody()) );
    }

    private boolean compareResponse (ResponsePrice expected, ResponsePrice current){

        boolean valid = true;
        var expectedData = expected.getData();
        var currentData = current.getData();
        if(expectedData.getProductId().compareTo(currentData.getProductId())  != 0){
            valid = false;
        }else if(expectedData.getBrandId().compareTo(currentData.getBrandId())!= 0){
            valid = false;
        }else if(expectedData.getPriceList().compareTo(currentData.getPriceList())!= 0){
            valid = false;
        }else if(!expectedData.getDateStart().equals(currentData.getDateStart())){
            valid = false;
        }else if(!expectedData.getDateEnd().equals(currentData.getDateEnd())){
            valid = false;
        }else if(expectedData.getPrice().compareTo(currentData.getPrice()) != 0){
            valid = false;
        }
        return valid;

    }
}
