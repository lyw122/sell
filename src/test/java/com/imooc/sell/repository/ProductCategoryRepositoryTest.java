package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private  ProductCategoryRepository repository;

    @Test
    public void findOneTest(){


    }

    @Test
    public  void saveTest(){

        ProductCategory productCategory=new ProductCategory("女生最爱",3);
        ProductCategory  result=repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findAByCategoryTypeInTest(){
        List<Integer> list= Arrays.asList(1,2);
        List<ProductCategory> result=repository.findAByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }



}