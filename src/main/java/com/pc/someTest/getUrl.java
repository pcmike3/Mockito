package com.pc.someTest;


import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

/**
 * @author panchi
 * @Type getUrl.java
 * @Desc
 * @date 2020/3/20 12:36
 */

public class getUrl {
    static String account = "18867121924";
    static String password = "Pc123456789";
    static String loginUrl = "http://login.kaixin001.com/";

    static HttpClient client = new HttpClient();

    public static void getUrlContent() throws IOException {
        HttpClientParams httpParams = new HttpClientParams();
        httpParams.setSoTimeout(5000);
        client.setParams(httpParams);

        client.getHostConfiguration().setHost("www.kaixin001.com", 80);
        client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        PostMethod login = new PostMethod(loginUrl);
        //设置MIME类型
        login.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        //NameValuePair loginAccount = new NameValuePair("account", account);
        //NameValuePair loginPwd = new NameValuePair("password", password);

        NameValuePair[] data = {new NameValuePair("account", account), new NameValuePair("password", password)};
        login.setRequestBody(data);
        //获得执行状态
        int statuscode = client.executeMethod(login);
        System.out.println(statuscode + "-----------");
        //String result = login.getResponseBodyAsString();
        System.out.println("++++++++++++");
        Cookie[] cookies = client.getState().getCookies();

        int i = 0;
        for (Cookie c : cookies) {
            System.out.println(++i + ":  " + c);
        }

        if ((statuscode == HttpStatus.SC_MOVED_TEMPORARILY)
                || (statuscode == HttpStatus.SC_MOVED_PERMANENTLY)
                || (statuscode == HttpStatus.SC_SEE_OTHER)
                || (statuscode == HttpStatus.SC_TEMPORARY_REDIRECT)){

        }else {
            System.out.println("用户没有登录");
        }

    }

    public static void main(String[] args) throws IOException {
        getUrlContent();
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/20 panchi create
 */ 
