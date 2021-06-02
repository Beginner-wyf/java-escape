package com.wyf.escape;

/**
 * @author wangyifan
 */
public class WhatIsNpe {
    public static class User{
        private String name;
        private String[] address;

        public void print(){
            System.out.println("这是User类");
        }

        public String readBook(){
            System.out.println("User在读书！");
            return null;
        }
    }

    /**
     * 自定义运行时异常
     */
    public static class CustomException extends RuntimeException{}

    public static void main(String[] args) {
        // 第一种产生空指针的情况：调用了空对象的实例方法(未进行实例化)
        //User user = null;
        //user.print();

        // 第二种情况：访问空对象的属性
        /*User user = null;*/
        /*System.out.println(user.name);*/

        // 第三种情况：当数组是一个空对象时，取它的长度
        /*User user = new User();*/
        /*System.out.println(user.address.length);*/

        // 第四种情况：thow一个为进行初始化的自定义异常
        /*CustomException exception =null;*/
        /*throw  exception;*/

        // 第五种情况：方法的返回值为null，未做校验直接使用
        User user = new User();
        System.out.println(user.readBook().equals("1"));
    }

}
