package com.wyf.escape;

import com.google.common.base.Enums;

import java.util.*;

/**
 * @author wangyifan
 * 编码中常见的异常
 */
public class GeneralException {
    public static class User{
        private String name;

        public String getName(){
            return name;
        }
        public User(){}
        public User(String name){
            this.name = name;
        }
    }

    public static class Manager extends User{}

    public static class Worker extends User{}

    /**
     * 并发修改异常:集合在遍历的过程中，不可对
     */
    private static void concurrentModificationException(ArrayList<User> users){
        /**
         * 直接使用for循环对集合元素进行删除，会触发快速失败机制，其底层逻辑是，当集合遍历时，会生成一个迭代器，迭代器会生成一个
         * 专门用于指向原集合数据的索引表，且迭代器的线程是独立出来的，当主线程中的集合对其中的元素进行删除，改变了集合大小，因为
         * 迭代器的索引表在另一个线程中，无法同步主线程的改变，从而导致并发修改异常
         */
        for (User user : users) {
            if (user.getName().equals("2")){
                users.remove(user);
            }
        }
        /**
         * 如要避免在迭代的过程中因为删除元素等操作而抛出异常，可以使用迭代器本身的方法来进行删除，具体如下
         */
//        Iterator<User> iterator = users.iterator();
//        while (iterator.hasNext()){
//            User next = iterator.next();
//            if (next.getName().equals("wyf")){
//                iterator.remove();
//            }
//        }
    }

    /**
     * 构建了一个枚举索引
     */
    private static final Map<String,StaffType> typeIndex = new HashMap<>( StaffType.values().length );

    static {
        for (StaffType value : StaffType.values()) {
            typeIndex.put(value.name(), value);
        }
    }

    private static StaffType enumFind(String type){
        /*return StaffType.valueOf(type);*/
        // 1、捕获异常
        /*try {
            return StaffType.valueOf(type);
        } catch (IllegalArgumentException e) {
            return null;
        }*/

        // 2、改进实现,自定义更加方便，但效率不高，如果枚举值过多就会降低效率
        /*for (StaffType value : StaffType.values()) {*/
        /*    if (value.name().equals(type)){*/
        /*        return value;*/
        /*    }*/
        /*}*/
        /*return null;*/

        // 3、静态map索引，只有一次遍历过程,其缺点是map中没有对应索引时可能返回null从而导致空指针异常
        /*return typeIndex.get(type);*/

        // 4、使用开源工具 Google Guava Enums,需要相关依赖
        return Enums.getIfPresent(StaffType.class,type).orNull();
    }

    public static void main(String[] args) {
        // 1并发修改异常
        /*ArrayList<User> users = new ArrayList<>(
                Arrays.asList(new User("1"), new User("2"))
        );
        concurrentModificationException(users);*/

        // 2类型转换异常
        /*User user1 = new Manager();
        User user2 = new Worker();*/

        /*Manager m1 = (Manager) user1;
        Manager m2 = (Manager) user2;

        System.out.println(user2.getClass().getName());
        System.out.println(user2 instanceof Manager);*/

        // 3枚举查找异常
        System.out.println(enumFind("PM"));
        System.out.println(enumFind("abc"));
    }

}
