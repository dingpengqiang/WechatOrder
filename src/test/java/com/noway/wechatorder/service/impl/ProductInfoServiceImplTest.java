package com.noway.wechatorder.service.impl;

import com.noway.wechatorder.dbobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl service;
    @Test
    public void findOne() {

        ProductInfo productInfo = service.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());

    }

    @Test
    public void findUpAll() {

        List<ProductInfo> upAll = service.findUpAll();

        Assert.assertNotEquals(0, upAll.size());
    }

    @Test
    public void findAll() {

//        PageRequest pageRequest = new PageRequest(0,2);
        PageRequest pageRequest =  PageRequest.of(0,2);
        Page<ProductInfo> page = service.findAll(pageRequest);
        long totalElements = page.getTotalElements();
        System.out.print(totalElements);

    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的虾" );
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(2);

        service.save(productInfo);
    }
}