package com.zxj.mapper;

import com.zxj.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 功能描述：用户持久层接口
 */
public interface UserMapper {


    //查询用户列表
    List<User> queryUserList(Map<String, Object> map);

    //查询用户
    int queryUser(Map<String, Object> map);

    //新增用户
    void addUser(Map<String, Object> map);

    //根据用户姓名更新用户信息
    void updateUser(Map<String, Object> map);

    //更加用户id更新用户信息
    void updateUserById(Map<String, Object> map);

    //删除用户
    void delUser(Map<String, Object> map);

    //修改用户密码
    void  updateUserPass(Map<String, Object> map);

}
