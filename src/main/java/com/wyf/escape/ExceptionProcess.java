package com.wyf.escape;

/**
 * @author wangyifan
 * 异常处理
 */
public class ExceptionProcess {

    public static class User{

    }

    /**
     * 异常的一个本质就是抛出异常
     * 另一个本质便是方法抛出异常，运行时系统将寻找潜在的异常处理器，当异常处理器所能处理的异常类型与方法相符，则视为找到合适的异常处理器，
     * 然后运行时系统会遍历方法调用栈中的方法来进行处理，若没有找到合适的异常处理器，则运行时系统终止，java程序终止
     */
    private void throwException(){
        User user = null;
        // 想要执行某个逻辑程序，但由于某个参数或者当前情况不允许继续向下执行，则抛出异常
        if (user == null){
            throw new NullPointerException();
        }
    }

    /**
     * 不能捕获异常
     */
    private void canNotCatchNpeException(){
        try {
            throwException();
        } catch (ClassCastException e) {//将捕获异常类型改为类型转换异常，就捕获不到NullPointerException
            System.out.println("捕获："+e.getMessage());
            System.out.println("捕获："+e.getClass().getName());
        }
    }
    /**
     * 能捕获异常
     */
    private void canCatchNpeException(){
        try {
            throwException();
        } catch (ClassCastException e) {//将捕获异常类型改为类型转换异常，就捕获不到NullPointerException
            System.out.println("捕获："+e.getMessage());
            System.out.println("捕获："+e.getClass().getName());
        }catch (NullPointerException npe){
            System.out.println("捕获："+npe.getMessage());
            System.out.println("捕获："+npe.getClass().getName());
        }
    }

    public static void main(String[] args) {
        ExceptionProcess exceptionProcess = new ExceptionProcess();
        //先调用可捕获的异常
        exceptionProcess.canCatchNpeException();
        //再调用不可捕获的异常，程序终止
        exceptionProcess.canNotCatchNpeException();
    }

}
