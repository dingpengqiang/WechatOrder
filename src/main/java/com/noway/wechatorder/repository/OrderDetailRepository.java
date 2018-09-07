package com.noway.wechatorder.repository;

import com.noway.wechatorder.dbobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {


    List<OrderDetail> findByOrderId(String orderId);
}