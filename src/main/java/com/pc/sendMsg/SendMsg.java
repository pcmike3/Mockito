package com.pc.sendMsg;

/**
 * @author panchi
 * @Type SendMsg.java
 * @Desc
 * @date 2020/3/23 19:33
 */

//public class SendMsg {
//    public static void main(String[] args) throws Exception {
//
//        HttpClient client = new HttpClient();
//
//        PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");
//
//        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
//
//        NameValuePair[] data = {
//
//                new NameValuePair("Uid", "qq2450759503"), // 注册的用户名
//
//                new NameValuePair("Key", "6e6105d6ac00786e0b7d"), // 注册成功后,登录网站使用的密钥
//
//                new NameValuePair("smsMob", "150********"), // 手机号码
//
//                new NameValuePair("smsText", "广州南洋理工职业学院欢迎您")};//设置短信内容
//
//        post.setRequestBody(data);
//
//        client.executeMethod(post);
//
//        Header[] headers = post.getResponseHeaders();
//
//        int statusCode = post.getStatusCode();
//
//        System.out.println("statusCode:" + statusCode);  //statusCode=200表示请示成功！
//
//        for (Header h : headers) {
//
//            System.out.println(h.toString());
//
//        }
//
//        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));  //设置编码格式
//
//        System.out.println(result);
//
//        post.releaseConnection();
//
//    }
//
//}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/23 panchi create
 */ 
