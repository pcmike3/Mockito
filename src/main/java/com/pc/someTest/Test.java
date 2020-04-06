package com.pc.someTest;

import com.jcraft.jsch.ChannelSftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @author panchi
 * @Type Test.java
 * @Desc
 * @date 2020/3/4 15:52
 */

public class Test {

    public static void main(String[] args) throws Exception {
        SFTPChannel channel = new SFTPChannel();
        Map<String,String> map = new HashMap<>();
        map.put("host","112.13.96.148");
        map.put("port","32222");
        map.put("username","zhhl");
        map.put("password","nb8w1U55Vye3K+Hh");
        ChannelSftp sftp = channel.getChannel(map, 100000);

        Vector ls = sftp.ls("/");
        String[] s = ls.toString().split(" ");
        String s1 = s[s.length-1];
        String s2 = s1.substring(0, s1.length() - 1);
        System.out.println("----------");
        System.out.println(s2);
        System.out.println("----------");

        InputStream in = sftp.get(s2);
        byte[] buffer = new byte[1024];
        OutputStream out = new FileOutputStream(new File("/Users/pcmike/Desktop/"+s2));
        int len=0;
        while((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }

        in.close();
        out.close();
        channel.closeChannel();
    }
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/4 panchi create
 */ 
