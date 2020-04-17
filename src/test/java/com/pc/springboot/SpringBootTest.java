package com.pc.springboot;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RunWith(MockitoJUnitRunner.class)
public class SpringBootTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test1() {
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    @Test
    public void test2() {
        //拼音的charArray是什么
        String name = "潘驰";
        System.out.println(name + ":" + name.getClass());
        char[] chars = name.toCharArray();
        System.out.println(chars);
        System.out.println(chars.length);
    }

    @Test
    public void test3() {
        String name = "着";
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
    public void test4() {
        String asdf = DigestUtils.md5Hex("asdf");
        System.out.println(asdf.length());
        String str = "abc/dss";
        String substring = str.substring(str.lastIndexOf("/"));
        System.out.println(substring);
    }

    @Test
    public void testHttpClient() throws IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod httpMethod = new PostMethod("https://www.cnblogs.com/ios9/p/7476601.html");
        int i = httpClient.executeMethod(httpMethod);
        System.out.println(httpMethod.getStatusLine());
        System.out.println(httpMethod.getStatusCode());
        System.out.println(httpMethod.getName());
        ;
        System.out.println(httpMethod.getParams());
        System.out.println("--------");
        System.out.println(httpMethod.getResponseBodyAsStream());
        System.out.println("--------");
        httpMethod.releaseConnection();
    }


    @Test
    public void test6() throws FileNotFoundException {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod("http://www.baidu.com");

        String response = "";
        client.getHttpConnectionManager().getParams().setConnectionTimeout(1000);
        try {
            int status = client.executeMethod(method);
            if (status == HttpStatus.SC_OK) {
                InputStream in = method.getResponseBodyAsStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                StringBuffer sb = new StringBuffer();
                String str = "";
                while ((str = bufferedReader.readLine()) != null) {
                    sb.append(str);
                }
                response = sb.toString();
            } else {
                response = "fail";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        System.out.println("---------------");
        System.out.println(response);
    }


    @Test
    public void test7() throws IOException {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod("http://www.baidu.com");
        client.executeMethod(method);
        client.getHostConfiguration().setHost("http://www.baidu.com",80);
    }


}
