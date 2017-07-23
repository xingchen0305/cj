package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Rent;
import com.bupt.repository.RentRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class RentService extends BasePageService<Rent, String> {
    @Autowired
    private RentRepository rentRepository;
    public void save(Rent entity) {
        rentRepository.save(entity);
    }

    public Rent findOne(String id) {
        return rentRepository.findOne(id);
    }
    public List<Rent> findAll(String id) {
        return rentRepository.findAll();
    }
    public void deleteById(String id) {
        rentRepository.delete(id);
    }


}
