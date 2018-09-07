package com.noway.wechatorder.controller;


import com.noway.wechatorder.VO.ProductInfoVO;
import com.noway.wechatorder.VO.ProductVO;
import com.noway.wechatorder.VO.ResultVO;
import com.noway.wechatorder.dbobject.ProductCategory;
import com.noway.wechatorder.dbobject.ProductInfo;
import com.noway.wechatorder.service.CategoryService;
import com.noway.wechatorder.service.ProductInfoService;
import com.noway.wechatorder.utils.ResultUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("buyer/product")
public class BuyerProductController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductInfoService productInfoService;


    @GetMapping("/list")
    public ResultVO list() {


        //TODO　1.查询上架产品
        List<ProductInfo> infoUpList = productInfoService.findUpAll();

        //TODO 2.一次性查询上架产品的类目
//        List<ProductCategory> categoryList = categoryService.findAll();
        //传统方法
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo :infoUpList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法
        List<Integer> categoryTypeList = infoUpList.stream()
                .map(ProductInfo::getCategoryType
        ).collect(Collectors.toList());

        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //TODO 3.数据拼装
        ArrayList<ProductVO> data = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> list = new ArrayList<>();
            for (ProductInfo productInfo : infoUpList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                    productInfoVO.setProductId(productInfo.getProductId());
//                    productInfoVO.setProductName(productInfo.getProductName());
//                    productInfoVO.setProductPrice(productInfo.getProductPrice());
//                    productInfoVO.setProductDescription(productInfo.getProductDescription());
//                    productInfoVO.setProductIcon(productInfo.getProductIcon());
                    //精简方法
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    list.add(productInfoVO);
                }
            }
            productVO.setList(list);
            data.add(productVO);
        }
        return ResultUtils.success(data);
    }
}
