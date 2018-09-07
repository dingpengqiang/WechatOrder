package com.noway.wechatorder.repository;

import com.noway.wechatorder.dbobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory>  findByCategoryTypeIn(List<Integer> categoryTypeList);
}
