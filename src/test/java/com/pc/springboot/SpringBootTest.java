package com.pc.springboot;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
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

    @Test
    public void test2(){
        //拼音的charArray是什么
        String name="潘驰";
        System.out.println(name+":"+name.getClass());
        char[] chars = name.toCharArray();
        System.out.println(chars);
        System.out.println(chars.length);
    }

    @Test
    public void test3(){
        String name="着";
        StringBuffer pybf = new StringBuffer();
        char[] arr = name.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if (temp != null && temp.length > 0) {
                        pybf.append(temp[0]).append(temp[1]).append(temp[2]).append(temp[3]);
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pybf.append(arr[i]);
            }
        }
        String trim = pybf.toString().replaceAll("\\W", "").trim();
        System.out.println(trim);
    }

    @Test
    public void test4(){
        String str="abc/dss";
        String substring = str.substring(str.lastIndexOf("/"));
        System.out.println(substring);
    }
}
