package com.qydcos.be.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hexiuyu on 2017/6/15.
 */
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("admin")
public class AdminController {
}
