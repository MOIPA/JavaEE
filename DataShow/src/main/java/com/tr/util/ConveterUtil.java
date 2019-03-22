package com.tr.util;

import com.tr.domain.Dress;
import com.tr.domain.Shoe;
import com.tr.vo.*;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ConveterUtil {

    public ConveterUtil() {
    }

    private static MapperFactory mapperFactory;
    private static MapperFacade mapperFacade;

    static  {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFacade = mapperFactory.getMapperFacade();
        mapperFactory.classMap(Shoe.class, BrandPriceMaxVO.class)
                .field("brand", "expensiveBrand").field("pricesAmountMax", "expensivePriceAmountMax")
                .byDefault().register();
        mapperFactory.classMap(Object[].class, SoldPercentageVO.class)
                .field("1", "percentage").field("0", "sale")
                .byDefault().register();
        mapperFactory.classMap(Object[].class, SoldBrandNumberVO.class)
                .field("0", "brand").field("1", "number")
                .byDefault().register();
        mapperFactory.classMap(Object[].class, BrandAveragePrice.class)
                .field("0", "brand").field("1", "avgPrice")
                .byDefault().register();
        mapperFactory.classMap(Object[].class, MerchantNumberVO.class)
                .field("0", "webSite").field("1", "number")
                .byDefault().register();
        mapperFactory.classMap(Object[].class, DiffPriceInterverNumberVO.class)
                .field("0", "priceInterver").field("1", "number")
                .byDefault().register();
        mapperFactory.classMap(Dress.class, DressVO.class).byDefault().register();
    }

    public static Object mapOneTowOne(Object from, Class<?> to) {
        Object map = mapperFacade.map(from, to);
        return map;
    }

}
