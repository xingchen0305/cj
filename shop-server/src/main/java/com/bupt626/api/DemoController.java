package com.bupt626.api;

import com.bupt626.entity.CommodityExt;
import com.bupt626.entity.CommodityType;
import com.bupt626.entity.Sell;
import com.bupt626.repository.CommodityExtRepository;
import com.bupt626.repository.CommodityTypeRepository;
import com.bupt626.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by i-hexiuyu on 2017/7/11.
 */
@RestController
public class DemoController {

    @Autowired
    SellRepository sellRepository;

    @Autowired
    CommodityTypeRepository commodityTypeRepository;

    @Autowired
    CommodityExtRepository commodityExtRepository;

    @GetMapping("/demo")
    @ResponseBody
    public Sell demo(){

        Sell one = sellRepository.findOne(1);
        CommodityExt one2 = commodityExtRepository.findOne(1);

        CommodityType one1 = commodityTypeRepository.findOne(1);
        return one;

    }
}
