package com.app.src.prices_search.domain.value_object;

import com.app.src.shared.domain.BusinessException;
import com.app.src.shared.domain.ConstanSystemException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdDataTest {


    private IdData idData;

    @Test
    void id_data_null_test() {
        //when
        var exception = assertThrows(BusinessException.class, () -> {
            idData = new IdData(null);
        });
        //then
        assertEquals(exception.getMessage(), ConstanSystemException.BAD_FORMAT_ID.getCode());
    }

    @Test
    void id_data_wrong_range_test() {
        //when
        var exception = assertThrows(BusinessException.class, () -> {
            idData = new IdData(-10L);
        });
        //then
        assertEquals(exception.getMessage(), ConstanSystemException.BAD_FORMAT_ID.getCode());
    }

    @Test
    void id_data_ok_test() {
        //when
        idData = new IdData(10L);
        //then
        assertNotNull(idData.getValue());
    }


}