package com.bupt626.service;

import com.bupt626.entity.Star;
import com.bupt626.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CJ on 2017/7/24.
 */
@Service
public class StarServiceImpl {
    @Autowired
    StarRepository starRepository;
    public List<Star> findByCommodityId(String commodityId){
       return starRepository.findByCommodityId(commodityId);
    }
    public void save(Star star){
        starRepository.save(star);
    }

}
