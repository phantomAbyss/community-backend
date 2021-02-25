package com.wy.community.utils;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStreamReader;

public class HttpClientUtils {

    private static CloseableHttpClient httpClient = HttpClients.createDefault();
    private static CloseableHttpResponse response = null;


    /**
     * 通过get方式获取数据
     * @return
     */
    public static String getDataByGet(String url) {
        // 请求数据
        HttpGet httpGet = new HttpGet(url);
        try {
            response = httpClient.execute(httpGet);
//            System.out.println("status-code = " + response.getStatusLine().getStatusCode());
            if (response == null || response.getStatusLine().getStatusCode() != 200) {
                return null;
            }
            return httpEntityToString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            close();
        }
        return null;
    }
    /**
     * 将httpEntity转化为字符串
     */
    private static String httpEntityToString(HttpEntity httpEntity) {
        if (httpEntity == null) {
            return null;
        }
        InputStreamReader reader = null;
        try {
            long contentLength = httpEntity.getContentLength();
            if (contentLength != -1 && contentLength < 2048) {
                return EntityUtils.toString(httpEntity, "UTF-8");
            }
            reader = new InputStreamReader(httpEntity.getContent(), "UTF-8");
            CharArrayBuffer buffer = new CharArrayBuffer(2048);
            char[] chs = new char[1024];
            int len = -1;
            while ((len = reader.read(chs)) != -1) {
                buffer.append(chs, 0, len);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void close() {
        try {
            httpClient.close();
            if(response != null)
            {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
