package com.pc.IO;

import org.junit.Test;

import java.io.File;

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
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/20 panchi create
 */ 
