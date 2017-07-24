package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.HttpUtil;
import com.bupt.common.utils.PropertiesUtil;
import com.bupt.domain.Book;
import com.bupt.domain.Commodity;
import com.bupt.domain.Rent;
import com.bupt.repository.CommodityRepository;
import com.bupt.repository.RentRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.util.*;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class CommodityService extends BasePageService<Commodity, String> {
    public static final String EQUIPMENT_IP = "http://10.105.242.74:8755";
    @Autowired
    private CommodityRepository rentRepository;
    @Autowired
    private BookService bookService;
    @Value("${equipment-server-url}")
    private String url;

    public Boolean save(Commodity entity,String token) throws Exception{
        if (StringUtils.isNotBlank(entity.getAssetId())){
            PropertiesUtil props = new PropertiesUtil();
            Map<String,String> paraem = new HashMap<>();
            paraem.put("publish","true");
            Map<String,String> header = new HashMap<>();
            header.put("Authorization",token);
            String code = HttpUtil.doPost( url + "/asset/" + entity.getAssetId(),paraem,header);
            if (!"200".equals(code)){
                return false;
            }
        }
        if (entity.getBook() != null){
            bookService.save(entity.getBook());
            entity.setInfoId(entity.getBook().getId());
        }
        rentRepository.save(entity);
        return true;
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
    public void pageByHql(PageEntity<Commodity> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from Commodity where 1=1 ");
        if (paramaMap.containsKey("businessType")) {
            sql.append(" and businessType =:businessType ");
        }
        if (paramaMap.containsKey("owner")) {
            sql.append(" and owner =:owner ");
        }
        if (paramaMap.containsKey("name")) {
            sql.append(" and name like:name ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);
         translate(pageEntity.getResults());
    }


    @Override
    protected void translate(List<Commodity> list) {
        for (Commodity commodity : list){

        }
    }
}
