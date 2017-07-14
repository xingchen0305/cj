package com.bupt626.api;

import com.bupt626.entity.Commodity;
import com.bupt626.entity.CommodityType;
import com.bupt626.entity.Sell;
import com.bupt626.repository.CommodityTypeRepository;
import com.bupt626.repository.SellRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by i-hexiuyu on 2017/7/12.
 */
@RestController
@RequestMapping("/commodity")
@Transactional
public class CommodityController {

    @Autowired
    private CommodityTypeRepository commodityTypeRepository;

    @Autowired
    private SellRepository sellRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/types")
    public List<CommodityType> commodityType(){
        return commodityTypeRepository.findAll();
    }

    @GetMapping("/sells")
    public List<Sell> sellCommodity(){
        return sellRepository.findAll();
    }

    @PostMapping("/sell")
    public ResponseEntity createSellCommodity(@RequestBody Map<String, Object> map){
        if(map.containsKey("commodity")){
            Commodity commodity = mapper.convertValue(map.get("commodity"), Commodity.class);
            Sell sell = new Sell();
            sell.setCommodity(commodity);
            if(map.containsKey("sPrice"))
                sell.setsPrice(new BigDecimal(map.get("sPrice").toString()));
            sellRepository.save(sell);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }
}
