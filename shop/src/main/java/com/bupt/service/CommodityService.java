package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.domain.Book;
import com.bupt.domain.Commodity;
import com.bupt.domain.Rent;
import com.bupt.repository.CommodityRepository;
import com.bupt.repository.RentRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class CommodityService extends BasePageService<Commodity, String> {
    @Autowired
    private CommodityRepository rentRepository;
    @Autowired
    private BookService bookService;

    public void save(Commodity entity) {
        if (entity.getBook() != null){
            bookService.save(entity.getBook());
            entity.setInfoId(entity.getBook().getId());
        }
        rentRepository.save(entity);
    }
    public void update(Commodity entity) {
        if(entity.getBook() != null && StringUtils.isNotBlank(entity.getBook().getId()))
            bookService.update(entity.getBook());
            rentRepository.save(entity);
    }

    public Commodity findOne(String id) {
        Commodity commodity = rentRepository.findOne(id);
        Book book = null;
        if (commodity != null && commodity.getInfoId() != null)
            book = bookService.findOne(commodity.getInfoId());
            if (book != null){
                commodity.setBook(book);
            }

        return commodity;
    }
    public List<Commodity> findAll(String id) {
        return rentRepository.findAll();
    }
    public void delete(String id) {
        Commodity commodity = this.findOne(id);
        if (commodity != null && commodity.getInfoId() != null){
            bookService.delete(commodity.getInfoId());
        }
        rentRepository.delete(id);
    }


}
