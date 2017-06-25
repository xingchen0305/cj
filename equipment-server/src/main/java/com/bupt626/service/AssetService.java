package com.bupt626.service;

import com.bupt626.common.base.PageEntity;
import com.bupt626.common.base.BasePageService;
import com.bupt626.domain.Asset;

import com.bupt626.repository.AssetRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void save(Asset entity) {
        assetRepository.save(entity);
    }

    public Asset findOne(String id) {
        return assetRepository.findOne(id);
    }

    public void deleteById(String ids) {
        assetRepository.delete(ids);
    }

    public void pageByHql(PageEntity<Asset> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from Asset where 1=1 ");
        if (paramaMap.containsKey("property")) {
            sql.append(" and property =:property ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);
    }

    @Override
    protected void translate(List<Asset> list) {
        super.translate(list);
        for(Asset entity:list){
            if(StringUtils.isNotBlank(entity.getWarehouse_id())){

            }
        }
    }
}