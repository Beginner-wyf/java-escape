package com.wyf.escape.ty_with_resources;

/**
 * @author wangyifan
 */
public class AutoClose implements AutoCloseable{

    @Override
    public void close() {
        System.out.println(">>>>调用close()");
        throw new RuntimeException("close()方法异常");
    }

    public void work() throws MyException{
        System.out.println(">>>>调用work()");
        throw new MyException("work()方法异常");
    }
}
