package com.bupt626.service;

import com.bupt626.common.BasePageService;
import com.bupt626.common.PageEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import com.bupt626.domain.BaseWarehouse;
import com.bupt626.repository.BaseWarehouseRepository;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.Map;

/**
 * Created by mengying on 2017/6/17.
 */
@Service
@Transactional
public class BaseWarehouseService extends BasePageService<BaseWarehouse,String> {
    @Autowired
    private BaseWarehouseRepository baseWarehouseRepository;
    @Autowired
    private BaseWarehouseRepository cod;

    public void save(BaseWarehouse entity){
        baseWarehouseRepository.save(entity);
    }

    public BaseWarehouse findOne(String id){
        return baseWarehouseRepository.findOne(id);
    }

    public void deleteById(String id){ baseWarehouseRepository.delete(id); }

    public void  pageByHql(PageEntity<BaseWarehouse> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from BaseWarehouse where 1=1 ");
        if (paramaMap.containsKey("name")){
            sql.append(" and name =:name ");
        }
        if (paramaMap.containsKey("location")){
            sql.append(" and location =:location ");
        }
        if (paramaMap.containsKey("username")){
            sql.append(" and username =:username ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }

   /* @Override
    protected void translate(List<BaseWarehouse> list) {
        super.translate(list);
        for (BaseWarehouse baseWarehouse:list ) {
            if (StringUtils.isNotBlank(baseWarehouse.getorgId())) {
                BaseOrganization baseOrganization = baseOrganizationService.findOne(baseWarehouse.getorgId());
                if (baseOrganization != null) {
                    baseWarehouse.setOrgName(baseOrganization.getName());
                }
            }
        }
    }*/
}
