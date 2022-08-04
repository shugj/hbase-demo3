package com.atguigu.test;

import org.apache.hadoop.conf.Configuration;
import org.junit.Test;

/**
 * User: shugj
 * Date:  2022-08-03 18:25
 */

public class TestConfiguration {
    @Test
    public void testRun(){
        Configuration conf = new Configuration();
        conf.addResource("hbase-site.xml");
//        System.out.println(conf);

        String s = conf.get("hbase.zookeeper.quorum");
        System.out.println(s);
    }

    public static void main(String[] args) {
//        Configuration conf = new Configuration();
//        conf.addResource("hbase-site.xml");
////        System.out.println(conf);
//
//        String s = conf.get("hbase.zookeeper.quorum");
//        System.out.println(s);
    }
}