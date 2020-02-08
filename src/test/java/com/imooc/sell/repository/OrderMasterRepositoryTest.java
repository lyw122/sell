package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private  final  String OPENID="110110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("17375175690");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal("2.5"));

        OrderMaster result=repository.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    void findByBuyerOpenid() throws Exception {
        PageRequest request=PageRequest.of(0,1);

        Page<OrderMaster> result=repository.findByBuyerOpenid(OPENID,request);
        System.out.println(result.getTotalElements());
    }
}