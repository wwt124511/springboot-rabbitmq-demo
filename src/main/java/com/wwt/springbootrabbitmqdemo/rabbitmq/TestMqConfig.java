package com.wwt.springbootrabbitmqdemo.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author wwt
 * @ClassName TestMqConfig.java
 * @Description 测试mq
 * @CreateTime 2022-12-29 16:06
 */
@Component
public class TestMqConfig {

    /***
     * mq01-key
     */
    public static final String COCO_KEY_01 = "coco_key_01";

    /***
     * mq01-queue 队列名称
     */
    public static final String COCO_QUEUE_01 = "coco_queue_01";

    /***
     * mq01-exchange 交换机
     */
    public static final String COCO_EXCHANGE_01 = "coco_exchange_01";

    /***
     * mq02-key
     */
    public static final String COCO_KEY_02 = "coco_key_02";

    /***
     * mq02-queue 队列名称
     */
    public static final String COCO_QUEUE_02 = "coco_queue_02";

    /***
     * mq02-exchange 交换机
     */
    public static final String COCO_EXCHANGE_02 = "coco_exchange_02";


    /***
     * mq01定义队列
     */
    @Bean(COCO_QUEUE_01)
    public Queue queue01() {
        return QueueBuilder.durable(COCO_QUEUE_01).build();
    }

    /***
     * mq01定义交换机
     */
    @Bean(COCO_EXCHANGE_01)
    public Exchange exchange01() {
        return ExchangeBuilder.topicExchange(COCO_EXCHANGE_01).durable(true).build();
    }

    /***
     * mq01绑定key、交换机、队列关系
     * @param exchange
     * @param queue
     * @return
     */
    @Bean
    public Binding binding01(@Qualifier(COCO_EXCHANGE_01) Exchange exchange, @Qualifier(COCO_QUEUE_01) Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(COCO_KEY_01).noargs();
    }


    /***
     * mq02定义队列
     */
    @Bean(COCO_QUEUE_02)
    public Queue queue02() {
        return QueueBuilder.durable(COCO_QUEUE_02).build();
    }

    /***
     * mq02定义交换机
     */
    @Bean(COCO_EXCHANGE_02)
    public Exchange exchange02() {
        return ExchangeBuilder.topicExchange(COCO_EXCHANGE_02).durable(true).build();
    }

    /***
     * mq02绑定key、交换机、队列关系
     * @param exchange
     * @param queue
     * @return
     */
    @Bean
    public Binding binding02(@Qualifier(COCO_EXCHANGE_02) Exchange exchange, @Qualifier(COCO_QUEUE_02) Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(COCO_KEY_02).noargs();
    }



    /***
     * mq03-key
     */
    public static final String COCO_KEY_03 = "coco_key_03";

    /***
     * mq03-queue 队列名称
     */
    public static final String COCO_QUEUE_03 = "coco_queue_03";

    /***
     * mq03-exchange 交换机
     */
    public static final String COCO_EXCHANGE_03 = "coco_exchange_03";

    /***
     * mq03定义队列
     */
    @Bean(COCO_QUEUE_03)
    public Queue queue03() {
        return QueueBuilder.durable(COCO_QUEUE_03).build();
    }

    /***
     * mq03定义交换机
     */
    @Bean(COCO_EXCHANGE_03)
    public Exchange exchange03() {
        return ExchangeBuilder.topicExchange(COCO_EXCHANGE_03).durable(true).build();
    }

    /***
     * mq03绑定key、交换机、队列关系
     * @param exchange
     * @param queue
     * @return
     */
    @Bean
    public Binding binding03(@Qualifier(COCO_EXCHANGE_03) Exchange exchange, @Qualifier(COCO_QUEUE_03) Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(COCO_KEY_03).noargs();
    }






}
