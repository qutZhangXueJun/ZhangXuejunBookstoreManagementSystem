package com.zxj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxj.mapper.OrderMapper;
import com.zxj.pojo.Order;
import com.zxj.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class OrderServiceIpml implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    //获取所有订单
    @Override
    public  Map<String,Object> queryOrderList(Map<String, Object> map){
        //当前页
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        //每页几条记录
        int pageSize = Integer.parseInt(map.get("pageSize").toString());

        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.queryOrderList(map);
        PageInfo pageInfo = new PageInfo(orderList);
        long total = pageInfo.getTotal();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("total", total);
        resultMap.put("rows", orderList);

        return  resultMap;
    }

    //根据时间查询订单
    @Override
    public Map<String,Object> queryOrderByDate (Map<String, Object> map){
        //当前页
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        //每页几条记录
        int pageSize = Integer.parseInt(map.get("pageSize").toString());

        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> resultList = orderMapper.queryOrderByDate(map);
        PageInfo pageInfo = new PageInfo(resultList);
        long total = pageInfo.getTotal();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("total", total);
        resultMap.put("rows", resultList);

        return  resultMap;
    }

    //添加订单
    @Override
    public void addOrder(Map<String, Object> map){
        orderMapper.addOrder(map);
    }

    //更新图书库存
    @Override
    public void updateInventory(Map<String, Object> map){
        orderMapper.updateInventory(map);
    }

    //编辑订单
    public  void editOrder(Map<String, Object> map){
        orderMapper.editOrder(map);
    }

    //删除订单
    @Override
    public void delOrder(Map<String, Object> map){
        orderMapper.delOrder(map);
    }

}
