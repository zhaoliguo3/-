package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory=repository.findOne(1);
        productCategory.setCategoryType(10990);
        repository.save(productCategory);
    }

    @Test
    @Transactional
    public void insertTest(){
        ProductCategory productCategory=new ProductCategory("中国红",1000);
        productCategory=repository.save(productCategory);
        Assert.assertNotNull(productCategory);
    }

    @Test
    @Transactional
    public void findMany(){
        List<Integer> categoryTypeList= Arrays.asList(10990,3,9);
        List list=repository.findByCategoryTypeIn(categoryTypeList);
        //Assert.assertNotNull(productCategory);
        Assert.assertNotEquals(0,list.size());
    }
}