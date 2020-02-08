package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private  final String BUYER_OPENID="1101110";

    private final String  ORDER_ID="1578643487079964706";

    @Test
    void create() {

        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("李老板");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList=new ArrayList<>();

        OrderDetail o1=new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);

        OrderDetail o2=new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(1);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result=orderService.create(orderDTO);
        log.info("【创建订单】result={}",result);

    }

    @Test
    void findOne() {
        OrderDTO result=orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result={}",result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    void findList() {
        PageRequest request=PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage=orderService.findList(BUYER_OPENID,request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }

    @Test
    void cancel() {
    }

    @Test
    void finish() {
    }

    @Test
    void paid() {
    }
}