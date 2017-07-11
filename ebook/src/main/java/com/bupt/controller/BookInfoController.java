package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.CentralLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ycliu
 * @Title: BookInfoController
 * @Description:
 * @date 2017/06/14 17:08:06
 */
@RestController
@RequestMapping("/bookInfo")
public class BookInfoController extends BaseCommonController {
    @Autowired
    private CentralLibraryService
    @Autowired
    private Bo

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(CentralLibrary entity){
        centralLibraryService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping("/save")
    public String saveOrUpdate( @RequestBody BookInfo entity){
        bookInfoService.save(entity);
        return sendSuccessMessage();
    }
}
