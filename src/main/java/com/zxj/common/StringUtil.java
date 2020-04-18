package com.zxj.common;

import eu.bitwalker.useragentutils.UserAgent;
import javax.servlet.http.HttpServletRequest;

public class StringUtil {

    /**
     * 功能描述：浏览器和系统信息
     * @param request
     * @return
     */
    public static String getBrowserSystemInfo(HttpServletRequest request){
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        String BSInfo = userAgent.getOperatingSystem() + "-" + userAgent.getBrowser() + "(" + userAgent.getBrowserVersion() + ")";
        return BSInfo;
    }
}
