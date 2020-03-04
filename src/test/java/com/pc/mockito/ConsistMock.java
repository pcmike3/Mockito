package com.pc.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * @author panchi
 * @Type ConsistMock.java
 * @Desc
 * @date 2020/2/26 13:53
 */

public class ConsistMock {

    @Mock
    private ConsistMock consistMock;

    @Mock
    private A a;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        B b=new B();
        when(a.a()).thenReturn(b);
        when(b.b()).thenReturn(1);
        int aa=a.a().b();
        System.out.println(aa);
    }



}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/2/26 panchi create
 */ 
