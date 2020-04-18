package com.zxj.aspect;

import com.zxj.common.IDUtil;
import com.zxj.common.StringUtil;
import com.zxj.controller.SysAccessLogController;
import com.zxj.service.ISysAccessLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：系统访问日志切面类
 */
@Aspect("sysAccessLogAspect")
public class SysAccessLogAspect {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysAccessLogService sysAccessLogService;
    //访问时间
    private Date accessDate;
    //日志信息Map
    private Map<String,Object> logMap=new HashMap<>();
    private Class clazz;  //访问类

    /**
     * 前置通知
     * @param jp
     */
    public void doBefore(JoinPoint jp){
        clazz = jp.getTarget().getClass();
        if(clazz!= SysAccessLogController.class){

            //日志ID
            logMap.put("logId", IDUtil.getUUID());

            //请求url
            String url = request.getRequestURL().toString();
            logMap.put("accessInterface",url);

            //请求Ip
            String ip = request.getRemoteAddr();
            logMap.put("accessIp",ip);

            //请求方式
            String requestType = request.getMethod();
            logMap.put("requestType",requestType);

            //访问的时间
            accessDate = new Date();
            logMap.put("accessDate",accessDate);

            //方法的参数
            String args = Arrays.toString(jp.getArgs());
            logMap.put("interfaceParams",args);

            //访问的浏览器信息
            String browserSystemInfo = StringUtil.getBrowserSystemInfo(request);
            logMap.put("accessSource",browserSystemInfo);
        }

    }

    /**
     * 后置通知
     * @param jp
     */
    public void doAfter(JoinPoint jp){
         if (clazz!=SysAccessLogController.class){
             long executeTime = new Date().getTime()-accessDate.getTime();

             //执行时长
             logMap.put("executeTime",executeTime);
             sysAccessLogService.saveSysLog(logMap);
         }
    }
}
