package com.pc.someTest;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * @author panchi
 * @Type Test.java
 * @Desc
 * @date 2020/3/4 15:52
 */

public class Test {

    public static void main(String[] args) throws IOException {
//        for (int i=1;i<10;++i) {
//            System.out.println(
//                    UUID.randomUUID().toString().replace("-","").toUpperCase());
//        }

//        Employee e1 = new Employee("mike",1,"a");
//        Employee e2 = new Employee("jack",2,"b");
//        User user = new User();
//        BeanUtils.copyProperties(e1,user);
//        System.out.println(user);
//
//        List<Employee> list = Arrays.asList(e1,e2);
//        List<User> output = new ArrayList<>();
        HttpGet httpGet = new HttpGet("www.baidu.com");
        RequestConfig request = null;
        httpGet.setConfig(request);

        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpResponse httpResponse = closeableHttpClient.execute(httpGet);

    }
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/4 panchi create
 */ 
