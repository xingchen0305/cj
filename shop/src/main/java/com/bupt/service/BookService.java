package com.bupt.service;

import com.bupt.common.utils.BeanUtills;
import com.bupt.domain.Book;
import com.bupt.repository.BookRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author ycliu
 * @Title: BookService
 * @Description:
 * @date 2017/07/21 20:10:26
 */
@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository repository;

    public void save(Book entity){
        repository.save(entity);
    }

    public void update(Book entity){
        if (StringUtils.isNotBlank(entity.getId())) {
            Book book = repository.findOne(entity.getId());
            BeanUtills.copyProperties(entity, book);
            repository.save(book);
        }
    }

    public Book findOne(String id){
        if (StringUtils.isNotBlank(id)){
            return repository.findOne(id);
        }
        return null;
    }

    public void delete(String id){
        if (StringUtils.isNotBlank(id)){
            repository.delete(id);
        }
    }
    public void insert(Book entity){
        repository.insert(entity);
    }
}
