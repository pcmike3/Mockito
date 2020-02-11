package com.pc.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NiceTest {

    @Mock(answer=Answers.RETURNS_DEEP_STUBS)
    private NiceService niceService;


    @Test
    public void testNice() {
        niceService.get().test();
    }
}
