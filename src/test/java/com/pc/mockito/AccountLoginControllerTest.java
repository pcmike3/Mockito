package com.pc.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {


    @Mock
    private AccountDao accountDao;
    @Mock
    private HttpServletRequest request;
    @Mock
    private AccountLoginController accountLoginController;

    @Test
    public void test() {

        Account account = new Account();
        Mockito.when(request.getParameter("userName")).thenReturn("mike");
        Mockito.when(request.getParameter("password")).thenReturn("123");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);
        accountLoginController.login(request);

    }
}
