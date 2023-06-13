package com.app.src.prices_search.domain.value_object;


import com.app.src.prices_search.domain.value_object.gateway.GetValueLong;
import com.app.src.shared.domain.BusinessException;
import com.app.src.shared.domain.ConstanSystemException;

public class IdData implements GetValueLong {

    private Long value;

    public IdData(Long idNumber) {

        boolean isOk = true;
        if (idNumber == null) {
            isOk = false;
        } else if (idNumber.intValue() <= 0) {
            isOk = false;
        }

        if (!isOk) {
            throw new BusinessException(ConstanSystemException.BAD_FORMAT_ID);
        }
        this.value = idNumber;
    }


    @Override
    public Long getValue() {
        return value;
    }
}
