package com.bupt626.service;

import com.bupt626.common.base.BasePageService;
import com.bupt626.common.base.PageEntity;
import com.bupt626.common.enums.AssetPropertyEnum;
import com.bupt626.common.enums.AssetStateEnum;
import com.bupt626.common.enums.PublicationTypeEnum;
import com.bupt626.domain.Asset;
import com.bupt626.domain.Book;
import com.bupt626.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Xtj on 2017/7/11.
 */
@Service
@Transactional
public class BookService extends BasePageService<Book, String> {
    @Autowired
    private BookRepository bookRepository;
    public void save(Book entity){
        bookRepository.save(entity);
    }
    public void pageByHql(PageEntity<Book> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from Book where 1=1 ");
        if (paramaMap.containsKey("type")) {
            sql.append(" and type =:type ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);
        translate(pageEntity.getResults());
    }
    @Override
    protected void translate(List<Book> list) {
        super.translate(list);
        for(Book entity:list){
            if(entity.getType()!=0){
               entity.setTypeName(PublicationTypeEnum.findByValue(entity.getType()));
                }
            }
        }
    }

