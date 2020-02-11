package com.pc.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockByAnnotation {

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountDao accountDao;

    @Test
    public void test(){
        Account account = accountDao.findAccount("1", "2");
        System.out.println(account);
    }
}
