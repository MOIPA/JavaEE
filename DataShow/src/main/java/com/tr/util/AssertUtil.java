package com.tr.util;

import com.tr.domain.ShoeErrorEnum;

import java.util.Objects;

public class AssertUtil {
    private AssertUtil() {
    }


    public static void AssertTrue(boolean bool, ShoeErrorEnum errorEnum) {
        if(!bool)
        throw new ServiceException(errorEnum.getErrorCode(), errorEnum.getErrorMessage());
    }

    public static void AssertNotNull(Object object, ShoeErrorEnum errorEnum) {
        if(Objects.isNull(object))
            throw new ServiceException(errorEnum.getErrorCode(), errorEnum.getErrorMessage());
    }

}
