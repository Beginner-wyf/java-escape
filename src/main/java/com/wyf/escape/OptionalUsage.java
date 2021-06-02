package com.wyf.escape;

import java.util.Optional;

/**
 * @author wangyifan
 * Optional规避空指针异常的操作
 */
public class OptionalUsage {

    public static class User{
        private String name;
        public String getName(){
            return name;
        }
    }

    private static void isUserEqualNull(){
        // 获取一个空的Optional实例
        Optional<User> optional = Optional.empty();
        if (optional.isPresent()){
            System.out.println("User is not Null");
        }else{
            System.out.println("User is Null");
        }
    }
    private static void isUserEqualNull2(){
        User user = null;
        Optional<User> user1 = Optional.of(user);
        Optional<User> user2 = Optional.ofNullable(user);
    }

    /*public static void main(String[] args) {
        isUserEqualNull();
    }*/
    public static User SupplierUser(){
        return new User();
    }

    public static void main(String[] args) {
        // 创建空对象
        User user = null;
        //创建Optional对象
        Optional<User> optional = Optional.ofNullable(user);
        // 存在则返回，为空则返回默认值
        optional.orElse(new User());
        // 存在则返回，为空则使用Supplier函数生成一个对象
        optional.orElseGet(()->SupplierUser());
        // 存在则返回，为空则抛出异常,具体异常类型可自定义
        optional.orElseThrow(RuntimeException::new);

        // 存在就去进行相应的处理，为空则不执行操作
        optional.ifPresent(User::getName);
        // map可以对Optional中的对象进行某种操作，其返回结果仍然是一个Optional对象
        optional.map(u -> u.getName()).orElse("WYF");
        // map可以无限的进行级联操作
        optional.map(u -> u.getName()).map(n -> n.length()).orElse(0);
    }
}
