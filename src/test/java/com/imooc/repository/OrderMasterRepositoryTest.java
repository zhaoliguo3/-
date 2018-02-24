package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author Donqiuxote
 * @data 2018/2/5 10:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void save(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("立国");
        orderMaster.setBuyerPhone("123456789");
        orderMaster.setBuyerAddress("浙江杭州");
        orderMaster.setBuyerOpenid("17862725526");
        orderMaster.setOrderAmount(new BigDecimal(88888));
        OrderMaster orderMaster1=repository.save(orderMaster);
        Assert.assertNotNull(orderMaster1);
    }
    @Test
    public void findByBuyerOpenid() {
        Pageable pageable=new PageRequest(0,2);
        Page<OrderMaster> orderMasters = repository.findByBuyerOpenid("17862725526", pageable);
        Assert.assertNotNull(orderMasters);
        Assert.assertNotEquals(0,orderMasters.getTotalElements());
    }
}