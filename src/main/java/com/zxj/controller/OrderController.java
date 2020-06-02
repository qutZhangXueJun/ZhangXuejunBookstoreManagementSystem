package com.zxj.controller;

import com.zxj.common.AssembleResponseMsg;
import com.zxj.service.IBookService;
import com.zxj.service.IOrderService;
import com.zxj.pojo.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IBookService bookService;

    //获取所有订单
    @RequestMapping(value = "/queryOrderList",produces = "application/json;charset=utf-8")
    public ResponseBody queryOrderList(@RequestBody Map<String,Object> map){
        Map<String, Object> resultMap = orderService.queryOrderList(map);
        return new AssembleResponseMsg().success(resultMap);
    }

    //根据时间查询订单
    @RequestMapping(value = "/queryOrderByDate",produces = "application/json;charset=utf-8")
    public ResponseBody queryOrderByDate(@RequestBody Map<String,Object> map){
        Map<String,Object> resultList = orderService.queryOrderByDate(map);
        return new AssembleResponseMsg().success(resultList);
    }

    //添加订单
    @RequestMapping(value = "/addOrder",produces = "application/json;charset=utf-8")
    public ResponseBody addOrder(@RequestBody Map<String,Object> map){
        try {
            orderService.addOrder(map);
            return new AssembleResponseMsg().success("OK");
        }catch (Exception e){
            return new AssembleResponseMsg().failure(200,"error","添加失败");
        }
    }


    //更新图书库存
    @RequestMapping(value = "/updateInventory",produces = "application/json;charset=utf-8")
    public ResponseBody updateInventory(@RequestBody Map<String,Object> map){
        bookService.updateInventtories(map);
        return new AssembleResponseMsg().success("OK");
    }

    //编辑订单
    @RequestMapping(value = "/editOrder", produces = "application/json;charset=utf-8")
    public ResponseBody editOrder(@RequestBody Map<String, Object> map){
        try {
            orderService.editOrder(map);
            return  new AssembleResponseMsg().success("OK");
        }catch (Exception e) {
            return new AssembleResponseMsg().failure(200, "error", "编辑失败");
        }
    }

    //删除订单
    @RequestMapping(value = "/delOrder",produces = "application/json;charset=utf-8")
    public ResponseBody delOrder(@RequestBody Map<String,Object> map){
        try {
            orderService.delOrder(map);
            return new AssembleResponseMsg().success("OK");
        }catch (Exception e){
            return new AssembleResponseMsg().failure(200,"error","添加失败");
        }
    }

}
