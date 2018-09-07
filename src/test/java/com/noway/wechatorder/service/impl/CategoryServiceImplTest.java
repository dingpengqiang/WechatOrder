package com.noway.wechatorder.service.impl;

import com.noway.wechatorder.dbobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

  @Autowired
  private CategoryServiceImpl service;
  @Test
  public void findOne() {

    ProductCategory productCategory = service.findOne(1);

    Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
  }

  @Test
  public void findAll() {

    List<ProductCategory> all = service.findAll();

    Assert.assertNotEquals(0,all.size());
  }

  @Test
  public void findByCategoryTypeIn() {

    List<ProductCategory> list = service.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4));

    Assert.assertNotEquals(0,list.size());
  }

  @Test
  public void save() {
    ProductCategory productCategory = new ProductCategory("男生专享", 10);
    service.save(productCategory);
  }
}