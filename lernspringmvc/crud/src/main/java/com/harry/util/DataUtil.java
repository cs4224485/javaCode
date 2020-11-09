package com.harry.util;

import com.harry.bean.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 模拟生成数据的工具类
 */
public class DataUtil {
    private static HashMap<String, User> dataMap = new HashMap<>();

    // 模拟初始化数据
    static {
        User user1 = new User("jack", "1888888888", "北京", LocalDate.of(2012, 01, 01));
        User user2 = new User("harry", "1666666666", "上海", LocalDate.of(2018, 04, 01));
        User user3 = new User("andy", "1999999999", "深圳", LocalDate.of(2017, 11, 11));
        dataMap.put("1", user1);
        dataMap.put("2", user2);
        dataMap.put("3", user3);
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    public static HashMap<String, User> findAll() {
        return dataMap;
    }

    /**
     * 根据id进行查询
     *
     * @param id
     * @return
     */
    public static User findUserById(String id) {
        return dataMap.get(id);
    }

    public static void create(User user) throws Exception {
        // 遍历map找到key的最大值
        Set<Map.Entry<String, User>> entries = dataMap.entrySet();
        Iterator<Map.Entry<String, User>> iterator = entries.iterator();
        int max = 3;
        while (iterator.hasNext()) {
            Map.Entry<String, User> next = iterator.next();
            int i = Integer.parseInt(next.getKey());
            if(max < i){
                max = i;
            }
        }
        // 将最大值做自增运算,然后作为key放到map中
        dataMap.put(++max + "", user);
    }

    public static void update(String id, User user) throws Exception {
        dataMap.put(id, user);
    }

    /**
     * 删除用户
     * @param id
     * @throws Exception
     */
    public static void Adelete(String id) throws Exception{
        dataMap.remove(id);
    }

}
