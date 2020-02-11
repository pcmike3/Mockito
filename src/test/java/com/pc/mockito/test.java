package com.pc.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class test {

    @Mock
    private List list;

    @Test
    public void test1(){

        Mockito.doNothing().when(list).clear();
        list.clear();
        Mockito.verify(list,Mockito.times(1)).clear();
    }
}
