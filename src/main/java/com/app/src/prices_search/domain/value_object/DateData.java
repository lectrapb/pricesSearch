package com.app.src.prices_search.domain.value_object;

import com.app.src.prices_search.shared.domain.BusinessConstant;
import com.app.src.shared.domain.BusinessException;
import com.app.src.shared.domain.ConstanSystemException;

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
