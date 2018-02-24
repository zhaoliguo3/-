package com.imooc.service.impl;

import com.imooc.DTO.OrderDTO;
import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Donqiuxote
 * @data 2018/2/9 11:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("赵a立国");
        orderDTO.setBuyerAddress("新a再灵");
        orderDTO.setBuyerOpenid("110a110");
        orderDTO.setBuyerPhone("1303a33");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail=new OrderDetail();

        orderDetail.setProductId("123556");
        orderDetail.setProductQuantity(1);

        OrderDetail orderDetail1=new OrderDetail();

        orderDetail1.setProductId("123456");
        orderDetail1.setProductQuantity(2);

        orderDetailList.add(orderDetail);
        orderDetailList.add(orderDetail1);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result={}",result);

        Assert.assertNotNull(result);

    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne("1518148519759353265");
        log.info("【创建订单】 result={}",result);
    }

    @Test
    public void findList() {
        Page<OrderDTO> orderDTOPage = orderService.findList("110a110", new PageRequest(0, 2));
        Assert.assertNotEquals(0,orderDTOPage);
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("1518398586793498834");
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("1518317332692472067");
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1518317219791414444");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }
}