package com.juhe.work2.service;

import com.alibaba.fastjson.JSONObject;
import com.juhe.work2.entity.QQTest;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.HttpURLConnection;
import java.io.IOException;

public class QQTestService {
        public static QQTest getQQTest(String qq){
        QQTest qqTest = new QQTest();
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod("http://japi.juhe.cn/qqevaluate/qq?key=534dc241ed77797daaaea485f5339ad8" +
                "&qq=" + qq );
        int code;
        String data;
        try {
            code = client.executeMethod(method);
            if (code == HttpURLConnection.HTTP_OK){
                data = method.getResponseBodyAsString();
                JSONObject jsonObject = JSONObject.parseObject(data);
                Object o = jsonObject.get("result");
                JSONObject jsonObject1 = JSONObject.parseObject(o.toString());
                qqTest = JSONObject.parseObject(jsonObject1.get("data").toString(), QQTest.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        method.releaseConnection();
        return qqTest;
    }
}
