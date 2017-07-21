package com.bupt626.controller;

import com.bupt626.common.base.BaseCommonController;
import com.bupt626.common.base.PageEntity;
import com.bupt626.common.utils.BeanUtills;
import com.bupt626.common.utils.DateUtil;
import com.bupt626.domain.AssetType;
import com.bupt626.service.AssetTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xtj on 2017/7/3.
 */
@RestController
@RequestMapping("/assetType")
public class AssetTypeController extends BaseCommonController {
    @Autowired
    private AssetTypeService assetTypeService;

    //添加属性信息
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody AssetType entity) {
        assetTypeService.save(entity);
        return sendSuccessMessage();
    }

    //更新属性信息
    @RequestMapping(value = "/AssetType", method = RequestMethod.PUT)
    public String update(@RequestBody AssetType entity) {
        if (StringUtils.isNotBlank(entity.getId())) {
            AssetType assetType = assetTypeService.findOne(entity.getId());
            BeanUtills.copyProperties(entity, assetType);
            assetTypeService.save(assetType);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();
        }
    }
    //查询属性信息
    @RequestMapping(value = "/AssetType/{code}", method = RequestMethod.GET)
    public String findByCode(@PathVariable(value = "code") String code) {
        AssetType assetType = assetTypeService.findByCode(code);
        return sendMessage("true", "", assetType, DateUtil.DATE);
    }
    //删除属性信息
    @RequestMapping(value = "/AssetType/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value = "id") String ids) {
        if (StringUtils.isNotBlank(ids)) {
            assetTypeService.deleteById(ids);
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
    public String page( AssetType entity,int page,int size) {
        int start=(page-1)*size;
        PageEntity<AssetType> pageEntity = new PageEntity<>(start,size,page);
        assetTypeService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(AssetType entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getName())) {
            parameterMap.put("name", entity.getName());
        }
        if (StringUtils.isNotBlank(entity.getCode())){
            parameterMap.put("code", entity.getCode());
        }
        return parameterMap;
    }
}
