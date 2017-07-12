package com.bupt626.service;

import com.bupt626.domain.BookRent;
import com.bupt626.repository.BookRentRepositpory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Xtj on 2017/7/11.
 */
@Service
@Transactional
public class BookRentService {
    @Autowired
    private BookRentRepositpory bookRentRepositpory;

    public void save(BookRent entity){
        bookRentRepositpory.save(entity);
    }

}
