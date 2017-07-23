package com.bupt.controller;

import com.bupt.service.FTPService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.bupt.common.utils.MessageUtil.sendSuccessMessage;

/**
 * Created by mengying on 2017/7/23.
 */

@RestController
@RequestMapping("/ftp")
public class FTPController {

    //上传图片到服务器10.105.242.65
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload(String localPath) {
        if (StringUtils.isNotBlank(localPath)) {
            String imagePath = FTPService.uploadFile(localPath);
            return sendSuccessMessage(imagePath);
        } else {
            return "false";
        }
    }
}
