package com.pc.someTest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

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
        BigDecimal aNull = new BigDecimal("0.2");
        System.out.println(aNull.toString());
    }

    @Test
    public void test3(){
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
            int i = ca.get(Calendar.DAY_OF_WEEK);
        System.out.println(i);
    }

    @Test
    public void test4() throws UnsupportedEncodingException {
        String a = "das&jd";
        System.out.println(Arrays.toString(a.getBytes()));
        System.out.println(Arrays.toString(a.getBytes("UTF-8")));

    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/29 panchi create
 */ 
