package com.app.src.prices_search.domain.value_object;

import com.app.src.prices_search.shared.ConstantTest;
import com.app.src.prices_search.shared.domain.BusinessConstant;
import com.app.src.shared.domain.BusinessException;
import com.app.src.shared.domain.ConstanSystemException;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateDataTest {


    private DateData dateToTest;

    @Test
    void date_data_null_test(){

        //given
        var exception = assertThrows(BusinessException.class, () ->{
            dateToTest = new DateData(null);
        });
        //then
        assertEquals(exception.getMessage(), ConstanSystemException.REQUIRE_ARGUMENT
                .getCode());
    }

    @Test
    void date_data_bad_format_date_test(){

        //given
        var exception = assertThrows(BusinessException.class, () ->{
            dateToTest = new DateData(ConstantTest.WRONG_FORMAT_DATE);
        });
        //then
        assertEquals(exception.getMessage(), ConstanSystemException.BAD_FORMAT_DATE
                .getCode());
    }

    @Test
    void date_data_ok_test(){
        //given
        SimpleDateFormat formatter = new SimpleDateFormat(
                BusinessConstant.FORMAT_DATE);
        dateToTest = new DateData(formatter.format(new Date()));

        //then
        assertNotNull(dateToTest.getValue());;
    }

}