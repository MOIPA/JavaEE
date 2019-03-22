package com.tr.service.impl;

import com.tr.dao.ShoesDao;
import com.tr.domain.Shoe;
import com.tr.domain.ShowErrorEnum;
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
        List<Shoe> expensiveBrandPrice = this.shoesDao.getExpensiveBrandPrice(PageRequest.of(0,50));
        /**
         * 判断是否为空
         */
        AssertUtil.AssertNotNull(expensiveBrandPrice, ShowErrorEnum.EMPTY_SHOE);
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
        List<Object[]> tmpList = this.shoesDao.getDiffPriceInterverNumber(PageRequest.of(0,50));
//        SoldPercentageVO out = (SoldPercentageVO) ConveterUtil.mapOneTowOne(soldPercentage.get(0), SoldPercentageVO.class);
        AssertUtil.AssertNotNull(tmpList, ShowErrorEnum.EMPTY_SHOE);
        List<DiffPriceInterverNumberVO> list = tmpList.stream()
                .map(data -> (DiffPriceInterverNumberVO) ConveterUtil.mapOneTowOne(data, DiffPriceInterverNumberVO.class))
                .collect(Collectors.toList());
        PageVO<DiffPriceInterverNumberVO> voList = new PageVO<>();
        voList.setTotal(list.size());
        voList.setData(list);
        return voList;
    }

    public PageVO<MerchantNumberVO> getMerchantNumber() {
        List<Object[]> tmpList = this.shoesDao.getMerchantNumber(PageRequest.of(0,50));
//        SoldPercentageVO out = (SoldPercentageVO) ConveterUtil.mapOneTowOne(soldPercentage.get(0), SoldPercentageVO.class);
        AssertUtil.AssertNotNull(tmpList, ShowErrorEnum.EMPTY_SHOE);
        List<MerchantNumberVO> list = tmpList.stream()
                .map(data -> (MerchantNumberVO) ConveterUtil.mapOneTowOne(data, MerchantNumberVO.class))
                .collect(Collectors.toList());
        PageVO<MerchantNumberVO> voList = new PageVO<>();
        voList.setTotal(list.size());
        voList.setData(list);
        return voList;
    }

    public PageVO<SoldPercentageVO> getSoldPercentage() {
        List<Object[]> tmpList = this.shoesDao.getSoldPercentage();
//        SoldPercentageVO out = (SoldPercentageVO) ConveterUtil.mapOneTowOne(soldPercentage.get(0), SoldPercentageVO.class);
        AssertUtil.AssertNotNull(tmpList, ShowErrorEnum.EMPTY_SHOE);
        List<SoldPercentageVO> list = tmpList.stream()
                .map(data -> (SoldPercentageVO) ConveterUtil.mapOneTowOne(data, SoldPercentageVO.class))
                .collect(Collectors.toList());
        PageVO<SoldPercentageVO> voList = new PageVO<>();
        voList.setTotal(list.size());
        voList.setData(list);
        return voList;
    }

    public PageVO<BrandAveragePrice> getBrandAvgPrice() {
        List<Object[]> tmpList = this.shoesDao.getBrandAvgPrice(PageRequest.of(0,50));
        AssertUtil.AssertNotNull(tmpList, ShowErrorEnum.EMPTY_SHOE);
        List<BrandAveragePrice> list = tmpList.stream()
                .map(data -> (BrandAveragePrice) ConveterUtil.mapOneTowOne(data, BrandAveragePrice.class))
                .collect(Collectors.toList());
        PageVO<BrandAveragePrice> voList = new PageVO<>();
        voList.setTotal(list.size());
        voList.setData(list);
        return voList;
    }

    public PageVO<SoldBrandNumberVO> getSoldBrandNumber() {
        List<Object[]> soldBrandNumber = this.shoesDao.getSoldBrandNumber(PageRequest.of(0,50));
        AssertUtil.AssertNotNull(soldBrandNumber, ShowErrorEnum.EMPTY_SHOE);
        List<SoldBrandNumberVO> list = soldBrandNumber.stream()
                .map(data -> (SoldBrandNumberVO) ConveterUtil.mapOneTowOne(data, SoldBrandNumberVO.class))
                .collect(Collectors.toList());
        PageVO<SoldBrandNumberVO> voList = new PageVO<>();
        voList.setTotal(list.size());
        voList.setData(list);
        return voList;
    }
}
