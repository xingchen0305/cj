package com.bupt626.service;

import com.bupt626.domain.Book;
import com.bupt626.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Xtj on 2017/7/11.
 */
@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void save(Book entity){
        bookRepository.save(entity);
    }
}
