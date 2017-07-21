package com.bupt626.api;

import com.bupt626.common.base.BaseCommonController;
import com.bupt626.common.base.Constants;
import com.bupt626.common.base.PageEntity;
import com.bupt626.common.enums.AssetPropertyEnum;
import com.bupt626.common.enums.AssetStateEnum;
import com.bupt626.common.utils.BeanUtills;
import com.bupt626.common.utils.DateUtil;
import com.bupt626.domain.Asset;
import com.bupt626.domain.AssetType;
import com.bupt626.domain.BaseWarehouse;
import com.bupt626.service.AssetService;

import com.bupt626.service.AssetTypeService;
import com.bupt626.service.BaseWarehouseService;

import com.bupt626.service.UserClient;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private AssetTypeService assetTypeService;

    @Autowired
    private UserClient userClient;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Asset entity) {
        assetService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Asset findOne(@PathVariable(value = "id") String id) {
        Asset asset = assetService.findOne(id);
        return asset;
    }

    //添加资产信息
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody Asset entity) {
        entity.setState(0);
        assetService.save(entity);
        return sendSuccessMessage();
    }

    //更新资产信息
    @RequestMapping(value = "/Asset", method = RequestMethod.PUT)
    public String update(@RequestBody Asset entity) {
        if (StringUtils.isNotBlank(entity.getId())) {
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
        if (StringUtils.isNotBlank(asset.getWarehouse_id())) {
            BaseWarehouse baseWarehouse = baseWarehouseService.findOne(asset.getWarehouse_id());
            if (baseWarehouse != null) {
//                String warehouseName = userClient.currentAccount().getDisplayName();
//                asset.setWarehouse_name(warehouseName);
                asset.setWarehouse_location(baseWarehouse.getLocation());
                asset.setWarehouse_user_name(baseWarehouse.getUsername());
            }
        }
        if (asset.getState() != null) {
            String stateName = AssetStateEnum.findByValue(asset.getState());
            asset.setStateName(stateName);
        }
        if (StringUtils.isNotBlank(asset.getCode())) {
            AssetType assetType = assetTypeService.findByCode(asset.getCode());
            asset.setType(assetType.getName());
        }
        //私有or公有
        if (asset.getProperty() != null) {
            asset.setPropertyName(AssetPropertyEnum.findByValue(asset.getProperty()));
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

    @RequestMapping("/page")
    public String page(Asset entity, int page, int size) {
        int start = (page - 1) * size;
        PageEntity<Asset> pageEntity = new PageEntity<>(start, size, page);
        assetService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String, Object> buildParameter(Asset entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (entity.getProperty() != null) {
            parameterMap.put("property", entity.getProperty());
        }
        if (StringUtils.isNotBlank(entity.getCode())) {
            parameterMap.put("code", entity.getCode());
        }
        if (entity.getState() != null) {
            parameterMap.put("state", entity.getState());
        }
        return parameterMap;
    }
}


