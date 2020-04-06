package com.pc.someTest;

import org.junit.Test;

/**
 * @author panchi
 * @Type Test.java
 * @Desc
 * @date 2020/3/29 20:18
 */

public class someTest {

    @Test
    public void test1(){
        A a = new A();
        B b = new B();
        b.setName("b");
        b.setAge(1);

        A a1 = (A)b;
        System.out.println(a1);
    }

    @Test
    public void test2(){
        String a="asb";
        System.out.println(a.charAt(0));
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/29 panchi create
 */ 
