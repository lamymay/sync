package com.arc.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 叶超
 * @since: 2019/8/6 11:44
 */
public class TestSocket {


    public static void main(String[] args) throws IOException {
        int port = 8009;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("serverSocket 在" + port + "创建成功");
        while (true) {
            //阻塞的获取一个套接字
            final Socket socket = serverSocket.accept();
            System.out.println("一个客户端  " + socket);
            //业务处理
            handler(socket);

        }

    }

    /**
     * 读取数据
     *
     * @param socket
     * @throws Exception
     */
    public static void handler(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();

            while (true) {
                //读取数据（阻塞）
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("socket关闭");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
