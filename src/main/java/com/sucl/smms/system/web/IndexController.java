package com.sucl.smms.system.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sucl
 * @since 2019/3/21
 */
@RestController
@RequestMapping
public class IndexController {

    @GetMapping("/hello")
    public String index(){
        return "hello";
    }
}
