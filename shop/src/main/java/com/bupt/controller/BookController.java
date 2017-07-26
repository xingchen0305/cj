package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.Book;
import com.bupt.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ycliu
 * @Title: BookController
 * @Description:
 * @date 2017/07/21 20:12:43
 */
@RestController
@RequestMapping("/book")
public class BookController extends BaseCommonController {
    @Autowired
    private BookService service;
    //添加属性信息
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody Book entity) {
        service.save(entity);
        System.out.println(entity.getId());
        return entity.getId();
    }

    //更新属性信息
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody Book entity) {
        if (StringUtils.isNotBlank(entity.getId())) {
            service.update(entity);
            return sendSuccessMessage();
        } else {
            return "success";
        }
    }
    //更新属性信息
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable("id") String id) {
        if (StringUtils.isNotBlank(id)) {
            return sendSuccessMessage(service.findOne(id));
        } else {
            return sendSuccessMessage();
        }
    }
    //更新属性信息
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") String id) {
        if (StringUtils.isNotBlank(id)) {
            service.delete(id);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();        }
    }
}
