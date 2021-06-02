package com.wyf.escape;

/**
 * @author wangyifan
 */
public class UnBoxingNpe {

    public static void main(String[] args) {
        // 变量赋值自动拆箱出现空指针
        Long count = null;
        long count_= count;

        // 方法传值时自动拆箱引发的空指针
        /*Integer x = null;
        Integer y = null;
        System.out.println(add(x, y));*/

        // 用于大小比较场景
        /*Long x = 10L;
        Long y = null;
        System.out.println(compare(x, y));*/
    }
    /*public static int add(int x,int y){
        return x+y;
    }
    public static boolean compare(long x, long y){
        return x >= y;
    }*/
}
