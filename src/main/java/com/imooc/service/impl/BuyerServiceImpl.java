package com.imooc.service.impl;

import com.imooc.DTO.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Donqiuxote
 * @data 2018/2/12 15:28
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    private OrderService orderService;

    public OrderDTO checkOwnerOrder(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){   //忽略大小写的字符串比较
            log.error("【查询订单】 订单的openid不一致. openid={}, orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERRO);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOwnerOrder(openid, orderId);
        if (orderDTO == null){
            log.error("【取消订单】 查不到该订单. orderid={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOwnerOrder(openid,orderId);
    }


}
