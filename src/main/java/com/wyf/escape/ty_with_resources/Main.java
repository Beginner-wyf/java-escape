package com.wyf.escape.ty_with_resources;

import java.io.*;

/**
 * @author wangyifan
 * 解决使用try finally的资源泄露隐患
 */
public class Main {
    /**
     * 传统方式实现对资源的关闭
     */
    private String traditionalTryCatch() throws IOException{

        // 1、 单一资源的关闭
        /*String line = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
        try {
            line = bufferedReader.readLine();
        } finally {
            //对于单一资源
            bufferedReader.close();
        }
        return line;*/

        // 2、 多个资源的关闭
        // 第一个资源
        /*FileInputStream in = new FileInputStream("");
        try{
            // 第二个资源
            FileOutputStream out = new FileOutputStream("");
            try {
                byte[] bytes = new byte[100];
                int n;
                while ((n = in.read(bytes)) >= 0){
                    out.write(bytes,0,n);
                }
            }finally {
                // 关闭第二个资源
                out.close();
            }
        }finally {
            // 关闭第一个资源，顺序不能错，若顺序有错会导致IO异常，需要按照资源打开顺序的逆序进行关闭
            in.close();
        }*/
        return null;
    }

    /**
     * java 7 引入的 try-with-resources 实现自动的资源关闭
     */
    private String newTryWithResources() throws IOException{
        // 1、 单个资源的使用与关闭
        /*try(BufferedReader bufferedReader = new BufferedReader(new FileReader(""))){
            return bufferedReader.readLine();
        }*/

        // 2、 多个资源的使用与关闭
        try (FileInputStream in = new FileInputStream("");  //第一个资源
             FileOutputStream out = new FileOutputStream("")//第二个资源
        ){
            byte[] bytes = new byte[100];
            int n;
            while ((n = in.read(bytes)) != -1){
                out.write(bytes,0,n);
            }
        }
        return null;
    }

    public static void main(String[] args) throws MyException {
        /*AutoClose autoClose = new AutoClose();
        try {
            //先运行work让他抛出异常
            autoClose.work();
        } finally {
            //再运行close让他抛出异常
            autoClose.close();
        }*/
        try(AutoClose autoClose = new AutoClose()){
            autoClose.work();
        }
    }
}
