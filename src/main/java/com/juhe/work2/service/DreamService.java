package com.juhe.work2.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.juhe.work2.entity.Dream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.HttpURLConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DreamService {
    public static List<Dream> getDream(String fid){
        List<Dream> dreamList = new ArrayList<>();
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod("http://v.juhe.cn/dream/category?fid="+fid+"&key=0a7d7d24cf0fc27f88564b5845665639");
        int code;
        String data;
        try {
            code = client.executeMethod(method);
            if (code == HttpURLConnection.HTTP_OK){
                data = method.getResponseBodyAsString();
                JSONObject jsonObject = JSONObject.parseObject(data);
                Object o = jsonObject.get("result");
                dreamList = JSONArray.parseArray(o.toString(),Dream.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        method.releaseConnection();
        return dreamList;
    }
}
