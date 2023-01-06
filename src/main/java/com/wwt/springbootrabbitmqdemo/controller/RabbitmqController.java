package com.wwt.springbootrabbitmqdemo.controller;

import com.wwt.springbootrabbitmqdemo.dto.UserDTO;
import com.wwt.springbootrabbitmqdemo.rabbitmq.TestMqConfig;
import com.wwt.springbootrabbitmqdemo.util.JsonUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wwt
 * @ClassName RabbitmqController.java
 * @Description TODO
 * @CreateTime 2023-01-04 21:50
 */
@RestController
@RequestMapping("/mq")
public class RabbitmqController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @Author wwt
     * @Description 测试rabbitmq队列传输字符串
     * @Param
     * @Return
     * @CreateTime 2023-01-04 21:54
     */
    @PostMapping("mqString")
    @ResponseBody
    public Object mqString(){
        rabbitTemplate.convertAndSend(TestMqConfig.COCO_EXCHANGE_01, TestMqConfig.COCO_KEY_01, "你好");
        Map<String,Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功");
        return map;
    }


    @PostMapping("mqObjectJson")
    @ResponseBody
    public Object mqObjectJson(){
        UserDTO user = new UserDTO("王文涛", 20);
        rabbitTemplate.convertAndSend(TestMqConfig.COCO_EXCHANGE_02, TestMqConfig.COCO_KEY_02, JsonUtil.toJson(user));
        Map<String,Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功");
        return map;
    }


    @PostMapping("mqObject")
    @ResponseBody
    public Object mqObject(){
        UserDTO user = new UserDTO("王文涛", 20);
        rabbitTemplate.convertAndSend(TestMqConfig.COCO_EXCHANGE_03, TestMqConfig.COCO_KEY_03, user);
        Map<String,Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功");
        return map;
    }


}
