package com.tr.controller;


import com.tr.service.impl.DressService;
import com.tr.vo.DressVO;
import com.tr.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dress")
@Api(tags = "裙子对外接口")
public class DressController {

    @Autowired
    private DressService service;

    @GetMapping("/mostlikeddress")
    @ApiOperation("点赞最多的裙子")
    public PageVO<DressVO> getMostLikedDress() {
        return this.service.getMostLikedDress();
    }

}
