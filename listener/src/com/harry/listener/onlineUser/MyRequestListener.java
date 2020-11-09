package com.harry.listener.onlineUser;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 监听request的创建
 */
public class MyRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // 获取request对象
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        // 获取客户端的IP地址
        String ip = request.getRemoteAddr();
        System.out.println(ip);

        // 获取ServletContext对象
        ServletContext sc = sre.getServletContext();
        Map<String, List<HttpSession>> ipMap = (Map<String, List<HttpSession>>)sc.getAttribute("ipMap");
        // 将ip作为key去map获取响应的value
        List<HttpSession> list = ipMap.get(ip);
        if(list == null){
            // 如果list是null, 则说明用户是第一次访问
            list = new ArrayList<>();
        }
        // 获取当前session
        HttpSession currentSession = request.getSession();
        // 遍历List, 如果存在当前session的话, 则说明是同一个会话中的请求， 无需处理
        for(HttpSession s: list){
            if(s == currentSession){
                return;
            }
        }
        // 放上面条件不满足的话， 则说明该ip创建了一个新的session对象, 需要将该对象加入到list中
        list.add(currentSession);
        // 将list添加到map中
        ipMap.put(ip, list);
        // 将map放到ServletContext中
        sc.setAttribute("ipMap", ipMap);

        // 因为在session销毁时，需要ip地址，所以将ip地址放到session域中
        currentSession.setAttribute("ip", ip);
    }
}
