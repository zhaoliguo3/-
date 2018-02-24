package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() {
       List<ProductInfo> productInfos= repository.findByProductStatus(0);
       Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void saveTest() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setCategoryType(9);
        productInfo.setProductDescription("好吃的皮蛋粥");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductPrice(new BigDecimal(5));
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(200);
        System.out.println(productInfo);
        ProductInfo result=repository.save(productInfo);
        Assert.assertNotNull(result);

    }
}