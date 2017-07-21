package com.bupt626.api;

import com.bupt626.common.base.BaseCommonController;
import com.bupt626.common.base.PageEntity;
import com.bupt626.common.utils.BeanUtills;
import com.bupt626.common.utils.DateUtil;
import com.bupt626.domain.BaseWarehouse;
import com.bupt626.service.BaseWarehouseService;
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

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(@RequestBody BaseWarehouse entity){
        baseWarehouseService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody BaseWarehouse entity, Principal user){
        entity.setUsername(user.getName());
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
    @RequestMapping(value = "/findById",method = RequestMethod.GET )
    public String findById(String id){
        BaseWarehouse baseWarehouse = baseWarehouseService.findOne(id);
        return sendSuccessMessage(baseWarehouse);
    }
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") String id){
        BaseWarehouse baseWarehouse = baseWarehouseService.findOne(id);
//        return sendSuccessMessage(baseWarehouse);
        return sendMessage("true","",baseWarehouse, DateUtil.DATE);
    }

    @RequestMapping("/page")
    public String page(BaseWarehouse entity,int page,int size,Principal user){
        entity.setUsername(user.getName());
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
        if (StringUtils.isNotBlank(entity.getUsername())){
            parameterMap.put("username", entity.getUsername());
        }
        return parameterMap;
    }

    @RequestMapping("/deleteById")
    public String deleteById(String id){
        baseWarehouseService.deleteById(id);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "/find/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable ("id") String id) {
        baseWarehouseService.deleteById(id);
        return sendSuccessMessage();
    }
}
