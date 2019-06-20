package com.juhe.work2.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.juhe.work2.entity.Almanac;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.HttpURLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 黄历 时辰
 */
public class AlmService {
    public static List<Almanac> getAlm(String date){
        List<Almanac> almanacList = new ArrayList<>();
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod("http://v.juhe.cn/laohuangli/h?date=" + date +"&key=3d1fa7bdabe32f42baf7be158f58ad9c");
        int code;
        String data;
        try {
            code = client.executeMethod(method);
            if (code == HttpURLConnection.HTTP_OK){
                data = method.getResponseBodyAsString();
                JSONObject jsonObject = JSONObject.parseObject(data);
                Object o = jsonObject.get("result");
                almanacList = JSONArray.parseArray(o.toString(),Almanac.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        method.releaseConnection();
        return almanacList;
    }
}
