package com.pc.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class test {

    @Mock
    private List list;

    @Mock
    private MockitoService service;

    @Spy
    private List<String> list1 = new ArrayList<>();
    @Test
    public void test1(){

        Mockito.doNothing().when(list).clear();
        list.clear();
        Mockito.verify(list,Mockito.times(1)).clear();
    }

    @Test
    public void testRealCall(){
        list1.add("a");
        Assert.assertThat(list1.get(0),equalTo("a"));

    }
}
