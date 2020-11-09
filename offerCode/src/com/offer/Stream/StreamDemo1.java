package com.offer.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * 题目：请跟进给出数据，找出同时满足以下条件的用户，也即以下条件全部满足 偶数ID且年龄大于24且用户转为大写且用户名字字母倒序
 * 只输出一个用户名字
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        User user1 = new User(11, "a", 23);
        User user2 = new User(12, "b", 24);
        User user3 = new User(13, "c", 22);
        User user4 = new User(14, "d", 28);
        User user5 = new User(16, "e", 26);
        List<User> userList = Arrays.asList(user1, user2, user3, user4, user5);

        userList.stream().filter(u -> {
            return u.getId() % 2 == 0;
        }).filter(user -> {
            return user.getAge() > 24;
        }).map(u -> {
            return u.getName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).collect(Collectors.toList());

    }
}
