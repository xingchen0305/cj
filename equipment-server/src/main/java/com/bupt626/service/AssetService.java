package com.bupt626.service;

import com.bupt626.common.base.BasePageService;
import com.bupt626.common.base.PageEntity;
import com.bupt626.common.enums.AssetPropertyEnum;
import com.bupt626.common.enums.AssetStateEnum;
import com.bupt626.domain.Asset;

import com.bupt626.domain.AssetType;
import com.bupt626.domain.BaseWarehouse;
import com.bupt626.repository.AssetRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class AssetService extends BasePageService<Asset, String> {
    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private BaseWarehouseService baseWarehouseService;
    @Autowired
    private AssetTypeService assetTypeService;
    @Autowired
    private UserClient userClient;
    public void save(Asset entity) {
        assetRepository.save(entity);
    }

    public Asset findOne(String id) {
        return assetRepository.findOne(id);
    }
    public List<Asset> findAll(String id) {
        return assetRepository.findAll();
    }
    public void deleteById(String ids) {
        assetRepository.delete(ids);
    }

    public void pageByHql(PageEntity<Asset> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from Asset where 1=1 ");
        if (paramaMap.containsKey("property")) {
            sql.append(" and property =:property ");
        }
        if (paramaMap.containsKey("code")) {
            sql.append(" and code =:code ");
        }
        if (paramaMap.containsKey("state")) {
            sql.append(" and state =:state ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);
        translate(pageEntity.getResults());
    }

    @Override
    protected void translate(List<Asset> list) {
        super.translate(list);
        for(Asset entity:list){
            if(StringUtils.isNotBlank(entity.getWarehouse_id())){
                BaseWarehouse baseWarehouse=  baseWarehouseService.findOne(entity.getWarehouse_id());
               if(baseWarehouse!=null) {
//                   String warehouseName=userClient.currentAccount().getDisplayName();
//                   entity.setWarehouse_name(warehouseName);
                   entity.setWarehouse_location(baseWarehouse.getLocation());
                   entity.setWarehouse_user_name(baseWarehouse.getUsername());
               }
            }
            //是否发布
            if(entity.getState()!=null){
                entity.setStateName(AssetStateEnum.findByValue(entity.getState()));
            }
            //资产属性解析
            if(StringUtils.isNotBlank(entity.getCode())){
               AssetType assetType=assetTypeService.findByCode(entity.getCode());
               entity.setType(assetType.getName());
            }
            //私有or公有
            if(entity.getProperty()!=null){
               entity.setPropertyName(AssetPropertyEnum.findByValue(entity.getProperty()));
            }
        }
    }

}
