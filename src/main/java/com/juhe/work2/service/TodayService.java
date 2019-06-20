package com.juhe.work2.service;

import com.alibaba.fastjson.JSONObject;
import com.juhe.work2.entity.Today;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.HttpURLConnection;

import java.io.IOException;

/**
 * 黄历 今天
 */
public class TodayService {
    public static Today getTod(String date){
        Today today = new Today();
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod("http://v.juhe.cn/laohuangli/d?date="+date+"&key=3d1fa7bdabe32f42baf7be158f58ad9c");
        int code;
        String data;
        try {
            code = client.executeMethod(method);
            if (code == HttpURLConnection.HTTP_OK){
                data = method.getResponseBodyAsString();
                JSONObject jsonObject = JSONObject.parseObject(data);
                Object o = jsonObject.get("result");
                today = JSONObject.parseObject(o.toString(),Today.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        method.releaseConnection();
        return today;
    }
}
