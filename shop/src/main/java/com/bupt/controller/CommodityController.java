package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.Book;
import com.bupt.domain.Commodity;
import com.bupt.service.BookService;
import com.bupt.service.CommodityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //添加属性信息
    @RequestMapping( value = "",method = RequestMethod.POST)
    public String save(@RequestBody Commodity entity, Principal principal) {
        entity.setOwner(principal.getName());
        String imagePath = saveImage(entity.getImageList());
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
        for(String image : imageList){
            System.out.println(image);
            imagePath.append(image).append(",");
        }
        if (imagePath.length() > 1) {
            path = imagePath.substring(0, imagePath.length() - 1).toString();
        }
        return  path;
    }
}
