package com.tr.service;

import com.tr.vo.*;

public interface ShoesService {

    /**
     * 哪些品牌的价格最高？
     * 假设超过1000元为高价格品牌
     * @return
     */
    PageVO<BrandPriceMaxVO> getExpensiveBranAndPrice();

    /**
     * 哪些价格分布最广？
     * 通过大致浏览价格水平，大致确认价格区间
     * @param Limit  价格分界点 2500一下或者以上
     * @return
     */
    PageVO<DiffPriceInterverNumberVO> getInterverNumberUnderLimit(int Limit);

    /**
     *各类网站对于女鞋销售占比
     * 销售网站最多是哪个网站
     * @return
     */
    PageVO<MerchantNumberVO> getMerchantNumber();

    /**
     * 商品是否被消费者购买
     * @return
     */
    PageVO<SoldPercentageVO> getSoldPercentage();

    /**
     * 每个不同品牌的平均价格是多少？
     * @return
     */
    PageVO<BrandAveragePrice> getBrandAvgPrice();

    /**
     * 统计数据中仅有20%商品售出，接下来进一步分析售出的鞋子属于什么品牌
     */
    PageVO<SoldBrandNumberVO> getSoldBrandNumber();
}
