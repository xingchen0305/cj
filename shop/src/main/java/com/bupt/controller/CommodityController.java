package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Book;
import com.bupt.domain.Commodity;
import com.bupt.service.BookService;
import com.bupt.service.CommodityService;
import com.bupt.service.FTPService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import sun.misc.BASE64Decoder;

import javax.xml.soap.Detail;
import java.io.FileInputStream;
import java.net.URI;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private RestTemplate restTemplate;
    //添加属性信息
    @RequestMapping( value = "",method = RequestMethod.POST)
    public String save(@RequestBody Commodity entity, Principal principal) throws Exception{
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication)principal;
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)oAuth2Authentication.getDetails();
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
        String token = details.getTokenType() + " " + details.getTokenValue();
        boolean result = service.save(entity,token);
        if (result){
            return sendSuccessMessage();
        }else {
            return sendFailMessage("资产错误，发布失败");
        }
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

    @RequestMapping("/page")
    public String page( Commodity entity,int page,int size) {
        int start=(page-1)*size;
        PageEntity<Commodity> pageEntity = new PageEntity<>(start,size,page);
        service.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(Commodity entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getName())) {
            parameterMap.put("name", entity.getName());
        }
        if (StringUtils.isNotBlank(entity.getOwner())) {
            parameterMap.put("owner", entity.getOwner());
        }
        if (StringUtils.isNotBlank(entity.getBusinessType())){
            parameterMap.put("businessType", entity.getBusinessType());
        }
        return parameterMap;
    }
}
