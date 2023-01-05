package com.wwt.springbootrabbitmqdemo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.wwt.springbootrabbitmqdemo.dto.UserDTO;
import com.wwt.springbootrabbitmqdemo.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author wwt
 * @ClassName Mq01Consumer.java
 * @Description mq01队列消费者
 * @CreateTime 2023-01-04 22:06
 */
@Component
@Slf4j
public class Mq01Consumer {



    /**
     * @Author wwt
     * @Description mq01-队列消费 队列传输字符串
     * @Param
     * @Return
     * @CreateTime 2023-01-04 22:06
     */
    @RabbitListener(queues = {TestMqConfig.COCO_QUEUE_01})
    public void mqQueue01(String messageString, Message message, Channel channel) throws IOException {
        try {
            log.info("mq01消费执行，mq传参：{}", messageString);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            log.error("mq01消费执行处理失败，错误原因：{}", e);
        }
    }

    /**
     * @Author wwt
     * @Description mq02-队列消费 队列传输对象
     * @Param
     * @Return
     * @CreateTime 2023-01-04 22:05
     */
    @RabbitListener(queues = {TestMqConfig.COCO_QUEUE_02})
    public void mqQueue02(UserDTO dto, Message message, Channel channel) throws IOException {
        log.info("mq02消费执行，mq传参：{}", JsonUtil.toJson(dto));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
