package com.bupt626.service;

import com.bupt626.domain.BookExchange;
import com.bupt626.repository.BookExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Xtj on 2017/7/11.
 */
@Service
@Transactional
public class BookExchangeService {
    @Autowired
    private BookExchangeRepository bookExchangeRepository;

    public void save(BookExchange entity){
        bookExchangeRepository.save(entity);
    }
}
