package com.tr.controller;

import com.tr.service.ShoesService;
import com.tr.util.Response;
import com.tr.util.ResponseFactory;
import com.tr.vo.BrandPriceMaxVO;
import com.tr.vo.PageVO;
import com.tr.vo.SoldPercentageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoe")
@Api(tags="女鞋")
public class ShoesController {

    @Autowired
    private ShoesService service;

    @GetMapping("/soldpercentage")
    @ApiOperation("获得售出率")
    public Response<PageVO<SoldPercentageVO>> getSoldPercentage() {
        return ResponseFactory.OkResponse(this.service.getSoldPercentage());
    }

    @GetMapping("/expensivebrand")
    @ApiOperation("哪些品牌的价格最高")
    public Response<PageVO<BrandPriceMaxVO>> getexpensiveBrand() {
        return ResponseFactory.OkResponse(this.service.getExpensiveBranAndPrice());
    }
    @GetMapping("/soldpercentage/{price}")
    @ApiOperation("价格分布")
    public Response<PageVO<SoldPercentageVO>> getInterval(@PathVariable int price) {
        return ResponseFactory.OkResponse(this.service.getInterverNumberUnderLimit(price));
    }
    @GetMapping("/websitesold")
    @ApiOperation("各类网站对于女鞋销售占比")
    public Response<PageVO<SoldPercentageVO>> getWebSiteSold() {
        return ResponseFactory.OkResponse(this.service.getMerchantNumber());
    }
    @GetMapping("/brandaverage")
    @ApiOperation("每个不同品牌的平均价格是多少？")
    public Response<PageVO<SoldPercentageVO>> getbrandAverage() {
        return ResponseFactory.OkResponse(this.service.getBrandAvgPrice());
    }
    @GetMapping("/soldbrandnumber")
    @ApiOperation("卖出鞋子不同品牌计数")
    public Response<PageVO<SoldPercentageVO>> getSoldBrandNumber() {
        return ResponseFactory.OkResponse(this.service.getSoldBrandNumber());
    }


}
