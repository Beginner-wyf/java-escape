package com.wyf.escape.ty_with_resources;

/**
 * @author wangyifan
 * 自定义异常
 */
public class MyException extends Exception{
    public MyException(){
        super();
    }
    public MyException(String msg){
        super(msg);
    }
}
