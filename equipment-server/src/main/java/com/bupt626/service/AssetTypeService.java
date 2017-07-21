package com.bupt626.service;

import com.bupt626.common.base.BasePageService;
import com.bupt626.common.base.PageEntity;
import com.bupt626.domain.AssetType;
import com.bupt626.repository.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Xtj on 2017/7/3.
 */
@Service
@Transactional
public class AssetTypeService extends BasePageService<AssetType,String> {
    @Autowired
    private  AssetTypeRepository assetTypeRepository;
    public void save(AssetType entity) {
        assetTypeRepository.save(entity);
    }

    public AssetType findOne(String id) {
        return assetTypeRepository.findOne(id);
    }
    public AssetType findByCode(String code){return assetTypeRepository.findByCode(code);}
    public List<AssetType> findAll(String id) {
        return assetTypeRepository.findAll();
    }
    public void deleteById(String ids) {
        assetTypeRepository.delete(ids);
    }

    public void pageByHql(PageEntity<AssetType> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from AssetType where 1=1 ");
        if (paramaMap.containsKey("code")) {
            sql.append(" and code =:code ");
        }
        if (paramaMap.containsKey("name")) {
            sql.append(" and name =:name ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);
      // translate(pageEntity.getResults());
    }
}
