package com.qydcos.be.controller;

import com.qydcos.be.entity.OAuthUser;
import com.qydcos.be.vo.UserForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hexiuyu on 2017/7/2.
 */

@Controller
public class OpenController {

    @GetMapping("/uuusss")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity createUser() {
        System.out.println("sd");
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
