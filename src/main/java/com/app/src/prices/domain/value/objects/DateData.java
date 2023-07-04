package com.app.src.prices.domain.value.objects;

import com.app.src.prices.shared.domain.BusinessConstant;
import com.app.src.prices.domain.exception.BusinessException;
import com.app.src.prices.domain.exception.ConstanSystemException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateData {

    private Date value;

    public DateData(String dateString) {

        SimpleDateFormat formatter = new SimpleDateFormat(BusinessConstant.FORMAT_DATE);

        Date currentDate = null;
        boolean isOk = true;
        if (dateString == null) {
            isOk = false;
        }
        if (!isOk) {
            throw new BusinessException(ConstanSystemException.REQUIRE_ARGUMENT);
        }
        try {
              currentDate = formatter.parse(dateString);
        } catch (ParseException e) {
            throw new BusinessException(ConstanSystemException.BAD_FORMAT_DATE);
        }
        this.value = currentDate;
    }

    public Date getValue(){
        return value;
    }
}
