package com.bupt626.controller;

import com.bupt626.common.base.BaseCommonController;
import com.bupt626.common.base.PageEntity;
import com.bupt626.common.enums.PublicationTypeEnum;
import com.bupt626.domain.*;

import com.bupt626.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xtj on 2017/7/11.
 */
@RestController
@RequestMapping("/book")
public class BookController extends BaseCommonController {
   @Autowired
   private BookService bookService;
    @Autowired
    private BookRentService bookRentService;
    @Autowired
    private BookSaleService bookSaleService;
    @Autowired
    private BookExchangeService bookExchangeService;

    @Autowired
    private EquipmentClient equipmentClient;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody Book entity, String id) {

        Asset asset1=equipmentClient.findById(id);
      //  entity.setId(asset1.getId());
        entity.setCreateTime(asset1.getCreateTime());
        entity.setName(asset1.getName());
        if(entity.getType()==1){
            entity.setTypeName(PublicationTypeEnum.findByValue(entity.getType()));
            BookSale bookSale=new BookSale();
           // bookSale.setId(asset1.getId());
            bookSale.setCreateTime(asset1.getCreateTime());
            bookSale.setSalePrice(entity.getSalePrice());
            bookSale.setSaleWay(entity.getSaleWay());
            bookSaleService.save(bookSale);
        }
        if(entity.getType()==2){
            entity.setTypeName(PublicationTypeEnum.findByValue(entity.getType()));
            BookRent bookRent=new BookRent();
            bookRent.setCreateTime(asset1.getCreateTime());
            bookRent.setRent(entity.getRent());
            bookRent.setDeposit(entity.getDeposit());
            bookRentService.save(bookRent);
        }
        if(entity.getType()==3){
            entity.setTypeName(PublicationTypeEnum.findByValue(entity.getType()));
            BookExchange bookExchange=new BookExchange();
            bookExchange.setCreateTime(asset1.getCreateTime());
            bookExchange.setWanted(entity.getWanted());
            bookExchange.setRemark(entity.getRemark());
            bookExchangeService.save(bookExchange);
        }
        bookService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping("/page")
    public String page(Book entity, int page, int size) {
        int start = (page - 1) * size;
        PageEntity<Book> pageEntity = new PageEntity<>(start, size, page);
        bookService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String, Object> buildParameter(Book entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (entity.getType()!=0) {
            parameterMap.put("type", entity.getType());
        }
        return parameterMap;
    }
}
