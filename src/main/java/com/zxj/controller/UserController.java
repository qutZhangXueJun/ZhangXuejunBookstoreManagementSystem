package com.zxj.controller;


import com.zxj.common.AssembleResponseMsg;
import com.zxj.pojo.ResponseBody;
import com.zxj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：用户控制层

 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 功能描述：查询用户列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryUserList",produces = "application/json;charset=utf-8")
    public ResponseBody queryUserList(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap = userService.queryUserList(map);
        return new AssembleResponseMsg().success(resultMap);
    }
//    @RequestMapping("/queryUser")
//    public int queryUser(@RequestParam Map map){
//        return 1;
//
//    }
    @RequestMapping(value = "/queryUser",produces = "application/json;charset=utf-8")
    public ResponseBody queryUser(@RequestBody Map<String,Object> map){
        int flag = userService.queryUser(map);
        String name = "zhangxuejun";
        Map<String,String> all = new HashMap<>();
        if(flag==1){//说明存在账号和密码，即登录账号和密码输入正确
            for (Map.Entry<String,Object> entry:map.entrySet()){
                System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
                if(entry.getValue().equals(name)){
                    all.put("token","admin");
                    break;
                }else{
                    all.put("token","editor");
                }
            }

            all.put("status","OK");
            return new AssembleResponseMsg().success(all);
        }else{
            return new AssembleResponseMsg().failure(200,"error","用户名或密码错误");
        }


    }

    /**
     * 功能描述：新增用户
     * @param map
     * @return
     */
    @RequestMapping(value = "/addUser",produces = "application/json;charset=utf-8")
    public ResponseBody addUser(@RequestBody Map<String,Object> map){
        userService.addUser(map);
        return new AssembleResponseMsg().success("OK");
    }

    /**
     * 功能描述：根据用户名更改用户信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateUser",produces = "application/json;charset=utf-8")
    public ResponseBody updateUser(@RequestBody Map<String,Object> map){
        userService.updateUser(map);
        return new AssembleResponseMsg().success("OK");
    }

    /**
     * 功能描述：根据用户ID更改用户信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateUserById",produces = "application/json;charset=utf-8")
    public ResponseBody updateUserById(@RequestBody Map<String,Object> map){
        userService.updateUserById(map);
        return new AssembleResponseMsg().success("OK");
    }

    /**
     * 功能描述：删除用户信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/delUser",produces = "application/json;charset=utf-8")
    public  ResponseBody delUser(@RequestBody Map<String,Object> map){
        userService.delUser(map);
        return new AssembleResponseMsg().success("OK");
    }

    /**
     * 功能描述：修改用户密码
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateUserPass",produces = "application/json;charset=utf-8")
    public ResponseBody updateUserPass(@RequestBody Map<String,Object> map){
        userService.updateUserPass(map);
        return new AssembleResponseMsg().success("OK");
    }

}
