package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.domain.CentralLibrary;
import com.bupt.repository.CentralLibraryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ycliu
 * @Title: CentralLibraryService
 * @Description:
 * @date 2017/06/14 16:53:19
 */
@Service
@Transactional
public class CentralLibraryService extends BasePageService<CentralLibrary,String> {

    @Autowired
    private CentralLibraryRepository repository;

    public void save(CentralLibrary entity ){
        if (entity != null ) {
            repository.save(entity);
        }
    }
    public CentralLibrary findOne(String id){
        if (StringUtils.isNotBlank(id) ) {
            return  repository.findOne(id);
        }else {
            return null;
        }
    }

    public void deleteById(String id){
        repository.delete(id);
    }
}
