package com.tr.util;

import com.tr.domain.Shoe;
import com.tr.vo.BrandPriceMaxVO;
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
    }

    public static Object mapOneTowOne(Object from, Class<?> to) {
        return mapperFacade.map(from, to);
    }

}
