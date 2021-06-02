package com.wyf.escape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyifan
 * 字符串、数组、集合在使用时出现空指针
 */
public class BasicUsageNpe {
    public static void main(String[] args) {
        // 字符串使用时报空指针异常
        /*System.out.println(stringEquals("1", null));
        System.out.println(stringEquals(null, "1"));*/

        // 对象数组new出来了，但元素未进行初始化
        /*User[] users = new User[10];
        for (User user : users) {
            user.name = "wyf";
        }*/

        // List对象add一个null是不报错的，但addAll会报空指针异常
        ArrayList<User> users = new ArrayList<>();
        User user = null;
        List<User> users_ = null;

        users.add(user);
        System.out.println(users);
        users.addAll(users_);
        System.out.println(users);

    }
    public static class User{
        private String name;
    }
    private static boolean stringEquals(String x,String y){
        return x.equals(y);
    }
}
