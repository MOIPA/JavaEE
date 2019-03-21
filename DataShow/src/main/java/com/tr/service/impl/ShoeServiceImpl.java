package com.tr.service.impl;

import com.tr.dao.ShoesDao;
import com.tr.domain.Shoe;
import com.tr.domain.ShoeErrorEnum;
import com.tr.service.ShoesService;
import com.tr.util.AssertUtil;
import com.tr.util.ConveterUtil;
import com.tr.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoeServiceImpl implements ShoesService {

    private final ShoesDao shoesDao;

    @Autowired
    public ShoeServiceImpl(ShoesDao shoesDao) {
        this.shoesDao = shoesDao;
    }


    public PageVO<BrandPriceMaxVO> getExpensiveBranAndPrice() {
        List<Shoe> expensiveBrandPrice = this.shoesDao.getExpensiveBrandPrice(PageRequest.of(0,13));
        /**
         * 判断是否为空
         */
        AssertUtil.AssertNotNull(expensiveBrandPrice, ShoeErrorEnum.EMPTY_SHOE);
        /**
         * .stream()转为流，map处理每个，放入处理函数，转为QuestionVO类型
         */
        List<BrandPriceMaxVO> list = expensiveBrandPrice.stream()
                .map(shoe -> (BrandPriceMaxVO)ConveterUtil.mapOneTowOne(shoe, BrandPriceMaxVO.class))
                .collect(Collectors.toList());
//        return questionDao.findByIdIn(questionIds).stream()
//                .map(q -> (QuestionVO) Converter.map(q, QuestionClazz.VO_CLAZZ.getClazzByType(q.getQuestionType())))
//                .collect(Collectors.toList());

        PageVO<BrandPriceMaxVO> voList = new PageVO<>();
        voList.setData(list);
        voList.setTotal(list.size());
        return voList;
    }

    public PageVO<DiffPriceInterverNumberVO> getInterverNumberUnderLimit(int Limit) {
        return null;
    }

    public PageVO<MerchantNumberVO> getMerchantNumber() {
        return null;
    }

    public PageVO<SoldPercentageVO> getSoldPercentage() {
        return null;
    }

    public PageVO<BrandAveragePrice> getBrandAvgPrice() {
        return null;
    }

    public PageVO<SoldBrandNumberVO> getSoldBrandNumber() {
        return null;
    }
}
