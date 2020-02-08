package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductInfoRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductStock(100);
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductIcon("http://xxxxx.jpa");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);


    }

    @Test
    void findByProductStatus() throws  Exception {


    }
}