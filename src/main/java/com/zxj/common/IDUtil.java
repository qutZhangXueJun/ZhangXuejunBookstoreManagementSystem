package com.zxj.common;

import java.util.UUID;

/**
 * 功能描述：各种ID工具类
 */
public class IDUtil {

    /**
     * 功能描述：获取uuid（以去掉'-'字符）
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
