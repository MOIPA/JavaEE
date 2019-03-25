package com.tr.controller;


import com.tr.service.impl.DressService;
import com.tr.vo.DressVO;
import com.tr.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/dress")
@Api(tags = "裙子对外接口")
public class DressController {

    @Autowired
    private DressService service;

    @GetMapping("/mostlikeddress")
    @ApiOperation("点赞最多的裙子")
    public ModelAndView mostLikedDress() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "tr");
        modelAndView.addObject("dressData",this.service.getMostLikedDress().getData().get(0));
        return modelAndView;
    }

    @GetMapping("/nationrank")
    public ModelAndView nationRank() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gd", "260");
        modelAndView.addObject("zj", "190");
        modelAndView.addObject("js", "180");
        modelAndView.addObject("sh", "160");
        modelAndView.addObject("bj", "155");
        modelAndView.addObject("sc", "145");
        modelAndView.addObject("sd", "130");
        modelAndView.addObject("hb", "100");
        modelAndView.addObject("hn", "90");
        modelAndView.addObject("fj", "70");
        return modelAndView;
    }
}
