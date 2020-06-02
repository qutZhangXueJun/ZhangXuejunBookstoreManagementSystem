package com.zxj.mapper;

import com.zxj.pojo.Order;
import java.util.List;
import java.util.Map;

public interface OrderMapper {

    //获取所有订单
    List<Order> queryOrderList(Map<String, Object> map);

    //根据时间查询订单
    public List<Map<String, Object>> queryOrderByDate (Map<String, Object> map);

    //添加订单
    void addOrder(Map<String, Object> map);

    //更新图书库存
    void updateInventory(Map<String, Object> map);

    //编辑订单
    void editOrder(Map<String, Object> map);

    //删除订单
    void delOrder(Map<String, Object> map);

}
