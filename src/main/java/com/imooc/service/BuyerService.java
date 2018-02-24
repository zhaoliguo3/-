package com.imooc.service;

import com.imooc.DTO.OrderDTO;

/**
 * @author Donqiuxote
 * @data 2018/2/12 15:26
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderId);

    OrderDTO cancelOrder(String openid,String orderId);
}
