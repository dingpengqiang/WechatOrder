package com.noway.wechatorder.repository;

import com.noway.wechatorder.dbobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;


    @Test
    public void saveTest() {

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("111111");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerPhone("18300000001");
        orderMaster.setBuyerAddress("杭州西湖区");
        orderMaster.setBuyerOpenid("wx00001");
        orderMaster.setOrderAmount(new BigDecimal(15));

        OrderMaster result = repository.save(orderMaster);

        Assert.assertNotNull(result);

    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(0, 2);

        Page<OrderMaster> page = repository.findByBuyerOpenid("wx00001", pageRequest);

        long totalElements = page.getTotalElements();

        System.out.print(totalElements);


    }
}