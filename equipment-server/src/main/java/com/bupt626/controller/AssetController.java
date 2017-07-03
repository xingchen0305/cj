package com.bupt626.controller;

import com.bupt626.common.base.BaseCommonController;
import com.bupt626.common.base.Constants;
import com.bupt626.common.base.PageEntity;
import com.bupt626.common.utils.BeanUtills;
import com.bupt626.common.utils.DateUtil;
import com.bupt626.domain.Asset;
import com.bupt626.domain.BaseWarehouse;
import com.bupt626.service.AssetService;

import com.bupt626.service.BaseWarehouseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xtj on 2017/6/18.
 */
@RestController
@RequestMapping("/asset")
public class AssetController extends BaseCommonController {

    @Autowired
    private AssetService assetService;
    @Autowired
    private BaseWarehouseService baseWarehouseService;
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Asset entity) {
        assetService.save(entity);
        return sendSuccessMessage();
    }

    //添加资产信息
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody Asset entity) {
        assetService.save(entity);
        return sendSuccessMessage();
    }

    //更新资产信息
    @RequestMapping(value = "/Asset", method = RequestMethod.PUT)
    public String update(@RequestBody Asset entity) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(entity.getId())) {
            Asset asset = assetService.findOne(entity.getId());
            BeanUtills.copyProperties(entity, asset);
            assetService.save(asset);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();
        }
    }

    //查询资产信息
    @RequestMapping(value = "/Asset/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable(value = "id") String id) {
        Asset asset = assetService.findOne(id);
        if(StringUtils.isNotBlank(asset.getWarehouse_id())){
            BaseWarehouse baseWarehouse=  baseWarehouseService.findOne(asset.getWarehouse_id());
            asset.setWarehous_location(baseWarehouse.getLocation());
            asset.setWarehous_name(baseWarehouse.getName());
            asset.setWarehous_user_name(baseWarehouse.getUsername());
        }
        return sendMessage("true", "", asset, DateUtil.DATE);
    }

    //删除资产信息
    @RequestMapping(value = "/Asset/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value = "id") String ids) {
        if (StringUtils.isNotBlank(ids)) {
            assetService.deleteById(ids);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();
        }
    }
    /* @RequestMapping("/deleteById")
     public String deleteById(String ids) {
         if (StringUtils.isNotBlank(ids)) {
             assetService.deleteById(ids);
             return sendSuccessMessage();
         } else {
             return sendFailMessage();
         }
     }*/

    @RequestMapping("/page")
    public String page( Asset entity,int page,int size) {
        int start=(page-1)*size;
        PageEntity<Asset> pageEntity = new PageEntity<>(start,size,page);
        assetService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String, Object> buildParameter(Asset entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getProperty())) {
            parameterMap.put("property", entity.getProperty());
        }
        if (StringUtils.isNotBlank(entity.getType())){
            parameterMap.put("type", entity.getType());
        }
        if (StringUtils.isNotBlank(entity.getState())){
            parameterMap.put("state", entity.getState());
        }
        return parameterMap;
    }
}


