package com.pc.someTest;

/**
 * @author panchi
 * @Type Http.java
 * @Desc
 * @date 2020/3/16 15:53
 */

import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 清水66 on 2017/8/28.
 */
class JsonGet {
    public static void main(String[] args){
        //创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpGet httpGet = new HttpGet("https://blog.csdn.net/zl834205311/article/details/79847746");
        System.out.println(httpGet.getRequestLine());
        try {
            //执行get请求
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            //获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            //响应状态
            System.out.println("status:" + httpResponse.getStatusLine());
            //判断响应实体是否为空
            if (entity != null) {
                System.out.println("contentEncoding:" + entity.getContentEncoding());
                parseJsonGet(EntityUtils.toString(entity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {                //关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //解析Json数据
    public static void parseJsonGet(String jsonString){

        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        //AppCommentsData类，存放评论的作者、评论内容等
        List<AppCommentsData> list = new ArrayList<AppCommentsData>();
        JSONObject obj= jsonObject.getJSONObject("obj");
        //商品评论信息
        JSONArray jsonArray = obj.getJSONArray("commentDetails");
        for(int i =0;i<jsonArray.size();i++){
            AppCommentsData appCommentsData = new AppCommentsData();
            appCommentsData.setApp_id(1);
            appCommentsData.setStore_id(1011);
            //评论作者
            appCommentsData.setAuthor(jsonArray.getJSONObject(i).getString("nickName"));
            //商品评论内容
            appCommentsData.setData(jsonArray.getJSONObject(i).getString("content"));
            //评分
            appCommentsData.setScore(jsonArray.getJSONObject(i).getInt("score"));
            list.add(appCommentsData);
        }
        System.out.println("输出appCommentsData//");
        for (int i=0;i<list.size();i++){
            AppCommentsData appCommentsData = list.get(i);
            System.out.println("name: ="+appCommentsData.getAuthor());
            System.out.println("content: ="+appCommentsData.getData());
            System.out.println("score: ="+appCommentsData.getScore());
        }
    }
}
@Getter
@Setter
class AppCommentsData {
    int id;
    int app_id;//app的id
    int store_id;//应用商店id
    String author;//评论人
    int score;//评分
    String  data;//评论内容
    //生成getter.setter方法
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/16 panchi create
 */ 
