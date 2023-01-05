package com.wwt.springbootrabbitmqdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wwt
 * @ClassName TestController.java
 * @Description TODO
 * @CreateTime 2023-01-04 21:37
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("userList")
    @ResponseBody
    public Object userList(){
        Map<String,Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功");
        return map;
    }
}
