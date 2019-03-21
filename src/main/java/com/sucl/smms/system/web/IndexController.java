package com.sucl.smms.system.web;

import com.sucl.smms.system.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @RestController = @Controller + @ResponseBody?
 * 然而必须没用
 * 同时@GetMapping无效
 * @author sucl
 * @since 2019/3/21
 */
@RestController
@RequestMapping
public class IndexController {
    @Autowired
    private BaseService baseService;

    public IndexController(){
        System.out.println("indexController");
    }

    @GetMapping("/hello")
    public String index(){
        baseService.save();
        return "hello";
    }
}
