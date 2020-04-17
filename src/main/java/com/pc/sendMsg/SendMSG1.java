package com.pc.sendMsg;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

/**
 * @author panchi
 * @Type SendMSG1.java
 * @Desc
 * @date 2020/3/23 19:35
 */

public class SendMSG1 {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://www.webchinese.com.cn/Login.shtml");
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");
        NameValuePair[] data = {
                new NameValuePair("Uid","pcmike"),
                new NameValuePair("Key", "d41d8cd98f00b204e980"),
                new NameValuePair("smsMob", "18867121773"),
                new NameValuePair("smsText", "波波你是世界上最最最最可爱的女孩子~")
        };
        post.setRequestBody(data);
        client.executeMethod(post);

        Header[] headers = post.getResponseHeaders();//接受返回的消息头
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for (Header h : headers){
            System.out.println(h.toString());
        }

        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));

        System.out.println(result);

        post.releaseConnection();
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/23 panchi create
 */ 
