package com.app.src.prices.domain.value.objects;


import com.app.src.prices.domain.exception.BusinessException;
import com.app.src.prices.domain.exception.ConstanSystemException;

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
