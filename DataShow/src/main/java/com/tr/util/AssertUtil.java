package com.tr.util;

import com.tr.domain.ShowErrorEnum;

import java.util.Objects;

public class AssertUtil {
    private AssertUtil() {
    }


    public static void AssertTrue(boolean bool, ShowErrorEnum errorEnum) {
        if(!bool)
        throw new ServiceException(errorEnum.getErrorCode(), errorEnum.getErrorMessage());
    }

    public static void AssertNotNull(Object object, ShowErrorEnum errorEnum) {
        if(Objects.isNull(object))
            throw new ServiceException(errorEnum.getErrorCode(), errorEnum.getErrorMessage());
    }

}
