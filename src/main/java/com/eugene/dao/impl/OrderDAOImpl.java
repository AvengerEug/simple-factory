package com.eugene.dao.impl;

import com.eugene.Enum.OrderStatusEnum;
import com.eugene.common.dao.mybatis.MyBatisDAO;
import com.eugene.dao.OrderDAO;
import com.eugene.model.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDAOImpl extends MyBatisDAO<Order, Long> implements OrderDAO {

    @Override
    public Order getById(Long id) {
        return super.getById(id);
    }

    @Override
    public void updateStatus(Long orderId, OrderStatusEnum status) {
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderId);
        map.put("status", status);
        // 此处应该还需要更新createdBy和lastModifiedTime的, 但是DB中没设置该字段, 所以就省略了
        this.getSqlSession().update(this.getSqlNameSpace() + "updateStatus", map);
    }
}
