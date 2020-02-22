package com.pc.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RunWith(MockitoJUnitRunner.class)
public class SpringBootTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test1(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
