package com.tr.service.impl;

import com.tr.dao.DressDao;
import com.tr.domain.Dress;
import com.tr.domain.ShowErrorEnum;
import com.tr.util.AssertUtil;
import com.tr.util.ConveterUtil;
import com.tr.vo.DressVO;
import com.tr.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DressService {

    @Autowired
    private DressDao dressDao;


    public PageVO<DressVO> getMostLikedDress() {
        Dress dress = this.dressDao.getMostLikedDress(PageRequest.of(0,1));
        AssertUtil.AssertNotNull(dress, ShowErrorEnum.EMPTY_DRESS);

        DressVO dressVO = (DressVO) ConveterUtil.mapOneTowOne(dress, DressVO.class);
        List<DressVO> list = new ArrayList<>();
        list.add(dressVO);
        return new PageVO<DressVO>(1,list);
    }
}
