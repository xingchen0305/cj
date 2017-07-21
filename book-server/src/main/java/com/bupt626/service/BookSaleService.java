package com.bupt626.service;

import com.bupt626.domain.BookSale;
import com.bupt626.repository.BookSaleReposipory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Xtj on 2017/7/11.
 */
@Service
@Transactional
public class BookSaleService {
    @Autowired
    private BookSaleReposipory bookSaleReposipory;
    public void save(BookSale entity){
        bookSaleReposipory.save(entity);
    }

}
