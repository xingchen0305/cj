package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.Book;
import com.bupt.domain.Commodity;
import com.bupt.service.BookService;
import com.bupt.service.CommodityService;
import com.bupt.service.FTPService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import java.io.FileInputStream;
import java.security.Principal;
import java.util.List;

/**
 * @author ycliu
 * @Title: BookController
 * @Description:
 * @date 2017/07/21 20:12:43
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController extends BaseCommonController {
    @Autowired
    private CommodityService service;
    @Autowired
    private FTPService ftpService;
    //添加属性信息
    @RequestMapping( value = "",method = RequestMethod.POST)
    public String save(@RequestBody Commodity entity, Principal principal) {
        entity.setOwner(principal.getName());
        String imagePath = ftpService.saveImage(entity.getImageList());
        String cover = "";
        if (imagePath.contains(",")){
             cover = imagePath.split(",")[0];
        }else {
            cover = imagePath;
        }
        entity.setCover(cover);
        entity.getBook().setImageDetail(imagePath);
        service.save(entity);
        return sendSuccessMessage();
    }

    //更新属性信息
    @RequestMapping( value = "",method = RequestMethod.PUT)
    public String update(@RequestBody Commodity entity) {
        if (StringUtils.isNotBlank(entity.getId())) {
            service.update(entity);
            return sendSuccessMessage();
        } else {
            return sendFailMessage("id不能为空");
        }
    }
    //查找
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable("id") String id) {
        if (StringUtils.isNotBlank(id)) {
            return sendSuccessMessage(service.findOne(id));
        } else {
            return sendSuccessMessage();
        }
    }
    //删除
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") String id) {
        if (StringUtils.isNotBlank(id)) {
            service.delete(id);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();        }
    }

    private String saveImage(List<String> imageList){
        String path = null;
        StringBuilder imagePath = new StringBuilder("");
        for(String imageBase64 : imageList){
            String[] imageArray = imageBase64.split(",");
            if (imageArray.length >= 1) {
                byte[] imageByte = Base64.decodeBase64(imageArray[1]);
            }
        }
        if (imagePath.length() > 1) {
            path = imagePath.substring(0, imagePath.length() - 1).toString();
        }
        return  path;
    }
}
