package com.tr.controller;

import com.google.gson.Gson;
import com.tr.service.ShoesService;
import com.tr.util.Response;
import com.tr.util.ResponseFactory;
import com.tr.vo.BrandAveragePrice;
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
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/shoe")
@Api(tags="女鞋")
public class ShoesController {

    @Autowired
    private ShoesService service;

    @GetMapping("/soldpercentage")
    @ApiOperation("获得售出率")
//    public Response<PageVO<SoldPercentageVO>> getSoldPercentage() {
//        ModelAndView modelAndView = new ModelAndView();
//        Response<PageVO<SoldPercentageVO>> resp = ResponseFactory.OkResponse(this.service.getSoldPercentage());
//        modelAndView.addObject("resp",resp);
//        modelAndView.addObject("name", "获得售出率");
//        return resp;
//    }
    /**
     * done
     * 已完成前后端
     */
        public ModelAndView getSoldPercentage() {
        ModelAndView modelAndView = new ModelAndView();
//        Response<PageVO<SoldPercentageVO>> resp = ResponseFactory.OkResponse();
        modelAndView.addObject("resp",this.service.getSoldPercentage().getData());
        modelAndView.addObject("name", "获得售出率");
        return modelAndView;
    }

    @GetMapping("/expensivebrand")
    @ApiOperation("哪些品牌的价格最高")
    public ModelAndView getexpensiveBrand() {
        ModelAndView modelAndView = new ModelAndView();
        Response<PageVO<BrandPriceMaxVO>> resp = ResponseFactory.OkResponse(this.service.getExpensiveBranAndPrice());
        modelAndView.addObject("resp",new Gson().toJson(resp.getData().getData()));
        modelAndView.addObject("name", "哪些品牌的价格最高");
        return modelAndView;
    }
    @GetMapping("/soldprice")
    @ApiOperation("价格分布")
    public ModelAndView getInterval() {
        ModelAndView modelAndView = new ModelAndView();
        Response<PageVO<SoldPercentageVO>> resp = ResponseFactory.OkResponse(this.service.getInterverNumberUnderLimit(1));
        modelAndView.addObject("resp",new Gson().toJson(resp.getData().getData()));
        modelAndView.addObject("name", "价格分布");
        return modelAndView;
    }
    @GetMapping("/websitesold")
    @ApiOperation("各类网站对于女鞋销售占比")
    public ModelAndView getWebSiteSold() {
        ModelAndView modelAndView = new ModelAndView();
        Response<PageVO<SoldPercentageVO>> resp = ResponseFactory.OkResponse(this.service.getMerchantNumber());
        modelAndView.addObject("resp",new Gson().toJson(resp.getData().getData()));
        modelAndView.addObject("name", "各类网站对于女鞋销售占比");
        return modelAndView;
    }

    /**
     * done
     * @return
     */
    @GetMapping("/brandaverage")
    @ApiOperation("每个不同品牌的平均价格是多少？")
    public ModelAndView getbrandAverage() {
        ModelAndView modelAndView = new ModelAndView();
        Response<PageVO<BrandAveragePrice>> resp = ResponseFactory.OkResponse(this.service.getBrandAvgPrice());
        modelAndView.addObject("resp",new Gson().toJson(resp.getData().getData()));
        modelAndView.addObject("name", "每个不同品牌的平均价格是多少");
        return modelAndView;
    }
    @GetMapping("/soldbrandnumber")
    @ApiOperation("卖出鞋子不同品牌计数")
    public ModelAndView getSoldBrandNumber() {
        ModelAndView modelAndView = new ModelAndView();
        Response<PageVO<SoldPercentageVO>> resp = ResponseFactory.OkResponse(this.service.getSoldBrandNumber());
        modelAndView.addObject("resp",new Gson().toJson(resp.getData().getData()));
        modelAndView.addObject("name", "卖出鞋子不同品牌计数");
        return modelAndView;
    }


}
