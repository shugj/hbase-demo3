package com.atguigu;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.AsyncConnection;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * User: shugj
 * Date:  2022-08-03 17:57
 */

public class HBaseConnection {
    // 声明一个静态属性
    public static Connection connection = null;
    static {
        // 1.创建连接
        // 默认使用同步连接
        try {
            // 使用读取本地文件的形式添加参数
            connection = ConnectionFactory.createConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() throws IOException {
        if (connection != null){
            // 判断连接是否为null
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {

//        // 1.创建连接配置参数
//        Configuration conf = new Configuration();
//
//        // 2.添加配置参数
//        conf.set("hbase.zookeeper.quorum","hadoop104,hadoop103,hadoop102");
//
//        // 3.创建连接
//        // hconnection-0x147ed70f
//        Connection connection = ConnectionFactory.createConnection(conf);
//
//        // 异步连接
//        // org.apache.hadoop.hbase.client.AsyncConnectionImpl@2ddc8ecb
////        CompletableFuture<AsyncConnection> asyncConnection = ConnectionFactory.createAsyncConnection(conf);
//
//        // 4.使用连接
//        System.out.println(connection);
//
//        // 5.关闭连接
//        connection.close();

        System.out.println(HBaseConnection.connection);

        HBaseConnection.closeConnection();

    }

}