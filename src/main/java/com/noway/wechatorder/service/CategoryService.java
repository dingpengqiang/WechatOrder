package com.noway.wechatorder.service;

import com.noway.wechatorder.dbobject.ProductCategory;

import java.util.List;

public interface CategoryService {


    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryId);

    ProductCategory save(ProductCategory productCategory);
}
