package com.bupt626.service;

import com.bupt626.common.base.BasePageService;
import com.bupt626.common.base.PageEntity;
import com.bupt626.domain.Account;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import com.bupt626.domain.BaseWarehouse;
import com.bupt626.domain.Organization;
import com.bupt626.repository.BaseWarehouseRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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
    private OrganizationServiceImpl organizationService;

    @Autowired
    private UserClient userClient;

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

    @Override
    protected void translate(List<BaseWarehouse> list) {
        super.translate(list);
        Account account = userClient.currentAccount();
        for (BaseWarehouse baseWarehouse:list ) {
            baseWarehouse.setDisplayName(account.getDisplayName());
            if (StringUtils.isNotBlank(baseWarehouse.getorgId())) {
                Organization organization = organizationService.findOne(baseWarehouse.getorgId());
                if (organization != null) {
                    baseWarehouse.setOrgName(organization.getName());
                }
            }
        }
    }



}
