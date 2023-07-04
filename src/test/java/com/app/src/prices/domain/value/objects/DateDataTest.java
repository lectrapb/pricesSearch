package com.app.src.prices.domain.value.objects;

import com.app.src.prices.shared.ConstantTest;
import com.app.src.prices.shared.domain.BusinessConstant;
import com.app.src.prices.domain.exception.BusinessException;
import com.app.src.prices.domain.exception.ConstanSystemException;
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