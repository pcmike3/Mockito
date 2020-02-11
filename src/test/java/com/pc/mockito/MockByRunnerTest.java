package com.pc.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {

    @Test
    public void testMock(){
        AccountDao accountDao = mock(AccountDao.class,RETURNS_SMART_NULLS);
        Account account = accountDao.findAccount("1","2");
        System.out.println(account);
    }
}
