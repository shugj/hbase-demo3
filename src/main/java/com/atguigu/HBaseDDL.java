package com.atguigu;

import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.junit.Test;

import java.io.IOException;

/**
 * User: shugj
 * Date:  2022-08-03 18:49
 */

public class HBaseDDL {
    // 声明一个静态属性
    public static Connection connection = HBaseConnection.connection;

    /**
     * 创建命名空间
     * @param namespace 命名空间名称
     */
    public static void createNamespace(String namespace) throws IOException {
        // 1.获取admin
        // 此处的异常先不要抛出 等待方法写完 再统一进行处理
        // admin的连接是轻量级的 不是线程安全的 不推荐池化或者缓存这个连接
        Admin admin = connection.getAdmin();

        // 2.调用方法创建命名空间
        // 代码相对shell更加底层，所以shell能够实现的功能，代码一定能实现
        // 所以需要填写完整的命名空间描述

        // 2.1 创建命名空间描述建造者 => 设计师
        NamespaceDescriptor.Builder builder = NamespaceDescriptor.create(namespace);

        // 2.2 给命名空间添加需求
        builder.addConfiguration("user","atguigu");

        // 2.3 使用builder构造出来对应的添加完成参数的对象
        admin.createNamespace(builder.build());

        // 3. 关闭admin
        admin.close();
    }


    public static void main(String[] args) throws IOException {
        // 测试创建命名空间
//        createNamespace("atguigu");

        // 其他代码
        System.out.println("其他代码");

        // 关闭hbase连接
        HBaseConnection.closeConnection();
    }

}