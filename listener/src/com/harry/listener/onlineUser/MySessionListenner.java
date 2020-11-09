package com.harry.listener.onlineUser;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;
import java.util.Map;

/**
 * 监听session的销毁
 */

public class MySessionListenner implements HttpSessionListener {

    /**
     * 当session销毁时,将session从对应的List中移除
     * 判断List是否为空, 如果为空, 则说明该ip已经离线, 将其从map中删除
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* 获取当前被销毁的session */
        HttpSession currentSession = se.getSession();
        // 获取ServletContext对象
        ServletContext sc = currentSession.getServletContext();
        // 从ServletContext域中获取map
        Map<String, List<HttpSession>> ipMap = (Map<String, List<HttpSession>>)sc.getAttribute("ipMap");
        // 从session中获取之前存放的ip
        String ip = (String)currentSession.getAttribute("ip");
        // 要根据ip地址map中找到相应的list
        List<HttpSession> list = ipMap.get(ip);
        // 将待销毁的session从list中移除
        list.remove(currentSession);
        // 如果list的长度是0的话, 说明该ip所创建的session全部失效(用户已下线)， 可以将ip从map中移除
        // 如果list的长度不是0的话, 则说明该ip所创建的session还在，将变化写到map中
        if(list.size() == 0){
            ipMap.remove(ip);
        }else {
            ipMap.put(ip, list);
        }
        // 将更新后的ipMap放到ServletContext域中
        sc.setAttribute("ipMap", ipMap);
    }
}
