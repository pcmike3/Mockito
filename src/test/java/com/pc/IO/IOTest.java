package com.pc.IO;

import org.junit.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author panchi
 * @Type IOTest.java
 * @Desc
 * @date 2020/3/20 15:38
 */

public class IOTest {

    @Test
    public void test1(){
        File file = new File("/Users/pcmike/Desktop/");
        String[] list = file.list();
        for (String str:list){
            System.out.println(str);
        }
    }

    @Test
    public void test2() throws UnknownHostException {
        InetAddress add = InetAddress.getLocalHost();
        System.out.println("add"+add);
        String hostAddress = add.getHostAddress();
        String hostName = add.getHostName();
        System.out.println(hostAddress);
        System.out.println(hostName);
    }

    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("1","1");
        map.put("2","2");
        System.out.println(map);
        System.out.println("---------------");
        Set set = map.entrySet();
        System.out.println(set
        );
    }

    @Test
    public void test4() throws UnsupportedEncodingException {
        String a = URLEncoder.encode("潘驰", "UTF-8");
        System.out.println(a);

        System.out.println(a.getBytes("GBK"));

    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/20 panchi create
 */ 
