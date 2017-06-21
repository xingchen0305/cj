package com.bupt626.controller;

import com.bupt626.common.BaseCommonController;
import com.bupt626.common.Constants;
import com.bupt626.common.PageEntity;
import com.bupt626.domain.Asset;
import com.bupt626.service.AssetService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    @RequestMapping(value="/testAsset", method= RequestMethod.POST)
    public String save(Asset entity) {
        assetService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value="/testAsset", method= RequestMethod.PUT)
    public String update(Asset entity) {
        assetService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping(value="/testAsset/{id}", method= RequestMethod.GET)
       public String findById(@PathVariable(value="id") String id) {
        Asset asset = assetService.findOne(id);
        return sendSuccessMessage(asset);
    }


    @RequestMapping(value="/testAsset/{id}", method=RequestMethod.DELETE)
    public String deleteById(@PathVariable(value="id")String ids) {
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
   public String page(Asset entity, int start) {
       PageEntity<Asset> pageEntity = new PageEntity<>(start, Constants.PAGE_SIZE);
       assetService.pageByHql(pageEntity, buildParameter(entity));
       return sendSuccessMessage(pageEntity);
   }

    private Map<String, Object> buildParameter(Asset entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getProperty())) {
            parameterMap.put("property", entity.getProperty());
        }
        return parameterMap;
    }
}


