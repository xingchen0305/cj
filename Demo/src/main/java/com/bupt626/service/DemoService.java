package com.bupt626.service;

import com.bupt626.domain.Demo;
import com.bupt626.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hexiuyu on 2016/12/16.
 */

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public List<Demo> findAllDemo(){
        return demoRepository.findAll();
    }
}
