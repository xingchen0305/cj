package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.domain.BookInfo;
import com.bupt.repository.BookInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ycliu
 * @Title: BookInfoService
 * @Description:
 * @date 2017/06/15 22:22:29
 */
@Service
@Transactional
public class BookInfoService extends BasePageService<BookInfo,String> {
    @Autowired
    private BookInfoRepository repository;

    public void save(BookInfo entity ){
        if (entity != null ) {
            repository.save(entity);
        }
    }
}
