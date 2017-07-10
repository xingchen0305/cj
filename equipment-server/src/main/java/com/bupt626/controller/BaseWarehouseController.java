package com.bupt626.controller;

import com.bupt626.common.base.BaseCommonController;
import com.bupt626.common.base.Constants;
import com.bupt626.common.base.PageEntity;
import com.bupt626.common.utils.BeanUtills;
import com.bupt626.common.utils.DateUtil;
import com.bupt626.domain.Account;
import com.bupt626.domain.BaseWarehouse;
import com.bupt626.service.BaseWarehouseService;
import com.bupt626.service.UserClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @Autowired
    UserClient userClient;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(@RequestBody BaseWarehouse entity){
        baseWarehouseService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody BaseWarehouse entity){
        baseWarehouseService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String update(@RequestBody BaseWarehouse entity){
        if (StringUtils.isNotBlank(entity.getId())){
            BaseWarehouse baseWarehouse = baseWarehouseService.findOne(entity.getId());
            BeanUtills.copyProperties(entity,baseWarehouse);
            baseWarehouseService.save(baseWarehouse);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }
    @RequestMapping(value = "/findById",method = RequestMethod.POST )
    public String findById(String id, Principal user){
        System.out.println(user.getName());
        Account account = userClient.currentAccount();

        BaseWarehouse baseWarehouse = baseWarehouseService.findOne(id);
        return sendSuccessMessage(baseWarehouse);
    }
    @RequestMapping("/find/{id}")
    public String find(@PathVariable("id") String id){
        BaseWarehouse baseWarehouse = baseWarehouseService.findOne(id);
//        return sendSuccessMessage(baseWarehouse);
        return sendMessage("true","",baseWarehouse, DateUtil.DATE);
    }

    @RequestMapping("/page")
    public String page(BaseWarehouse entity,int page,int size){
        int start = (page - 1) * size;
        PageEntity<BaseWarehouse> pageEntity = new PageEntity<>(start, size,page);
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
