package com.pc.someTest;

import java.util.UUID;

/**
 * @author panchi
 * @Type Test.java
 * @Desc
 * @date 2020/3/4 15:52
 */

public class Test {
    public static void main(String[] args) {
        for (int i=1;i<3;++i) {
            System.out.println(
                    UUID.randomUUID().toString().replace("-","").toUpperCase());
        }
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/4 panchi create
 */ 
