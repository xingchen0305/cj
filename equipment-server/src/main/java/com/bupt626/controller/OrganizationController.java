package com.bupt626.controller;

import com.bupt626.common.base.Text;
import com.bupt626.common.utils.Connection;
import com.bupt626.domain.BaseWarehouse;
import com.bupt626.domain.Organization;
import com.bupt626.service.OrganizationServiceImpl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.bupt626.common.utils.MessageUtil.sendFailMessage;
import static com.bupt626.common.utils.MessageUtil.sendSuccessMessage;

/**
 * Created by CJ on 2017/6/18.
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationServiceImpl organizationService;

    /*@
    @RequestMapping(value="/testAsset", method= RequestMethod.PUT)
    public String update(@RequestBody Asset entity) {
        assetService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping(value="/testAsset/{id}", method= RequestMethod.GET)
    public String findById(@PathVariable(value="id") String id) {
        Asset asset = assetService.findOne(id);
        return sendSuccessMessage(asset);*/

    /**
     * 插入、更新操作
     * @param organization
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate",method= RequestMethod.POST)
    public String saveOrUpdate(@RequestBody Organization organization){
        organizationService.save(organization);
        return sendSuccessMessage();
    }

    /**
     * 查询组织ID为id的所有信息，（名字、上级）
     * @param id
     * @return
     */
    @RequestMapping(value="/find/{id}",method= RequestMethod.GET)
    public String findOne(@PathVariable(value="id") String id){
        Organization organization = organizationService.findOne(id);
        if(organization!=null)
           return sendSuccessMessage(organization);
        else return sendFailMessage();
    }

    /**
     * 查询某个级别的所有组织，用于下拉框
     * @param level
     * @return
     */
    @RequestMapping(value="/level/{level}",method= RequestMethod.GET)
    public String findByLevel(@PathVariable(value="level") int level){
        List<Text> textList = organizationService.findByLevel(level);
        if(textList!=null)
            return sendSuccessMessage(textList);
        else return sendFailMessage();
    }

    /**
     * 查询ID为superior的所有下级
     * @param superior
     * @return
     */
    @RequestMapping(value="/superior/{superior}",method= RequestMethod.GET)
    public String findByLevel(@PathVariable(value="superior") String superior){
        List<Organization> orgList = organizationService.findBySuperior(superior);
        if(orgList!=null)
            return sendSuccessMessage(orgList);
        else return sendFailMessage();
    }

    @RequestMapping(value="/isbn/{isbn}",method=RequestMethod.GET)
    public String getBookInfo(@PathVariable(value="isbn") String isbn){
        //  String url="http://book.douban.com/isbn/"+isbn+"/";
        // String url="http://book.douban.com/isbn/9787560049724/";
        String url="https://api.douban.com/v2/book/isbn/"+isbn;
        // String url="https://api.douban.com/v2/book/isbn/:9787111128069";
        return Connection.getPolicyJson(url);
    }

    /**
     * 测试
     * @return
     */
    @RequestMapping("/getUserInfo/{isbn}")
    public String getUserInfo(@PathVariable(value="isbn") String isbn){
      //  String url="http://book.douban.com/isbn/"+isbn+"/";
       // String url="http://book.douban.com/isbn/9787560049724/";
       String url="https://api.douban.com/v2/book/isbn/"+isbn;
       // String url="https://api.douban.com/v2/book/isbn/:9787111128069";
        return Connection.getPolicyJson(url);
    }

    @RequestMapping("/export")
    public void export() throws IOException {
        String url = "https://img3.doubanio.com/lpic/s1106934.jpg";
        byte[] btImg = Connection.getImageFromNetByUrl(url);
        if (null != btImg && btImg.length > 0) {
            System.out.println("读取到：" + btImg.length + " 字节");
            String fileName = "百度.gif";
            Connection.writeImageToDisk(btImg, fileName);
        } else {
            System.out.println("没有从该连接获得内容");
        }

    }
    @RequestMapping("/upload")
    public String  upload() throws IOException {
        String url = "https://img3.doubanio.com/lpic/s1106934.jpg";
        byte[] btImg = Connection.getImageFromNetByUrl(url);

        //把request强转为多部件请求对象
      //  MultipartHttpServletRequest req=(MultipartHttpServletRequest) request;
        //根据文件名称获得文件对象
      //  CommonsMultipartFile img = (CommonsMultipartFile) req.getFile(fileName);
        //获取文件上传流
       // byte[] fbytes = img.getBytes();
        //文件名在服务器可能有重复
        /*String newfileName=System.currentTimeMillis()+"";
        Random r=new Random();
        for(int i=0;i<5;i++){
            newfileName+=r.nextInt(100);
        }*/
        //获取文件的扩展名
        String newFileName="ceshi";
      //  String originalFilename = img.getOriginalFilename();
      //  String suffix=originalFilename.substring(originalFilename.lastIndexOf("."));
        String suffix=url.substring(url.lastIndexOf("."));
        System.out.println("扩展名："+suffix);
        //创建jesy服务器 进行跨服务器上传
        Client client=Client.create();
        //把文件关联到远程服务器
        WebResource resource = client.resource("http://127.0.0.1:8080/test/"+newFileName+suffix);
        //上传
        resource.put(btImg);
    /* * ajax回调函数所需的参数 * fullPath：图片回显所需的完整路径 */
        String fullPath="http://10.105.242.65/images/"+newFileName+suffix;
    //    String result="{\"fullPath\":\""+fullPath+"\"}";

        return fullPath;
/*

        if (null != btImg && btImg.length > 0) {
            System.out.println("读取到：" + btImg.length + " 字节");
            String fileName = "百度.gif";
            Connection.writeImageToDisk(btImg, fileName);
        } else {
            System.out.println("没有从该连接获得内容");
        }*/

    }


}
