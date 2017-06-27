package com.bupt626.controller;

import com.bupt626.common.base.BaseCommonController;
import com.bupt626.common.base.Constants;
import com.bupt626.common.base.PageEntity;
import com.bupt626.domain.BaseWarehouse;
import com.bupt626.service.BaseWarehouseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengying on 2017/6/17.
 */
@RestController
@RequestMapping("/baseWarehouse")
public class BaseWarehouseController extends BaseCommonController {
    @Autowired
    private BaseWarehouseService baseWarehouseService;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(BaseWarehouse entity){
        baseWarehouseService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping("/save")
    public String save(@RequestBody BaseWarehouse entity){
        baseWarehouseService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "/findById",method = RequestMethod.GET )
    public String findById(String id){
        BaseWarehouse baseWarehouse = baseWarehouseService.findOne(id);
        return sendSuccessMessage(baseWarehouse);
    }
    @RequestMapping("/find/{id}")
    public String find(@PathVariable("id") String id){
        BaseWarehouse baseWarehouse = baseWarehouseService.findOne(id);
        return sendSuccessMessage(baseWarehouse);
    }

    @RequestMapping("/page")
    public String page(BaseWarehouse entity,int start){
        PageEntity<BaseWarehouse> pageEntity = new PageEntity<>(start, Constants.PAGE_SIZE);
        baseWarehouseService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(BaseWarehouse entity){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getName())){
            parameterMap.put("name", entity.getName());
        }
        if (StringUtils.isNotBlank(entity.getLocation())){
            parameterMap.put("location", entity.getLocation());
        }
        return parameterMap;
    }

    @RequestMapping("/deleteById")
    public String deleteById(String ids){
        if (StringUtils.isNotBlank(ids)){
            baseWarehouseService.deleteById(ids);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }
}
