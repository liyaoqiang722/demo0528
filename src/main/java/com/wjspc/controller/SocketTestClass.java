package com.wjspc.controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 79445 on 2018/10/9.
 */
public class SocketTestClass {


    public static void main(String[] args) throws IOException {
        //端口号的范围为1024-65535
        int port = 10086;
        ServerSocket serverSocket= null;
        Socket socket = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            //创建一个服务器端的Socket,绑定指定的端口,并监听此端口
            serverSocket = new ServerSocket(port);
            //调用ServerSocket的accept()方法开始监听,等待客户端连接
            socket = serverSocket.accept();
            //获取输入流,并读取客户端发送过来的信息
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String getMsg = bufferedReader.readLine();
            while (getMsg != null){
                System.out.println("这里是服务器端,我从客户端那里接收到了:" + getMsg);
                if(getMsg.equals("白昼行将")){
                    outputStream = socket.getOutputStream();
                    printWriter = new PrintWriter(outputStream);
                    printWriter.write("暗夜魔王");
                    printWriter.flush();
                }
                getMsg = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(printWriter != null){
                printWriter.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(inputStreamReader != null){
                inputStreamReader.close();
            }
            if(inputStream != null){
                inputStream.close();
            }
        }
    }

}
