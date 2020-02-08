package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDetailRepositoryTest {

    @Autowired
    private  OrderDetailRepository repository;

    @Test
    public  void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("11111112");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("1111122");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductQuantity(2);

        OrderDetail result=repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    void findByOrderId() {
        List<OrderDetail> orderDetailList=repository.findByOrderId("11111112");

        Assert.assertNotEquals(0,orderDetailList);

    }
}