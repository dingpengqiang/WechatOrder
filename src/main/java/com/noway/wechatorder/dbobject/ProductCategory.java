package com.noway.wechatorder.dbobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Table(name = "product_category")
@Entity
@Data
@DynamicUpdate
public class ProductCategory {


    /**
     * @Table 数据库表名（如果类名和数据库表面不对应，加该注解）
     * @Entity
     * @Data  生成set get toString 方法
     * @DynamicUpdate 动态更新时间
     */

    /**
     * TODO    关于hibernate5.1.0中Table 'spring.hibernate_sequence' doesn't exist的解决办法
     * 将id的生成策略 @GeneratedValue 设置成 @GeneratedValue(strategy = GenerationType.IDENTITY)
     */
    /* 类目id.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

//    private Date createTime;

//    private Date updateTime;


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
