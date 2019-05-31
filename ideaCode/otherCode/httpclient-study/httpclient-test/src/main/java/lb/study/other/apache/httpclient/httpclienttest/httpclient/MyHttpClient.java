package lb.study.other.apache.httpclient.httpclienttest.httpclient;

import lb.study.other.apache.httpclient.httpclienttest.HttpclientTestApplication;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/5/31 11:50
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HttpclientTestApplication.class)
public class MyHttpClient {

    @Autowired
    private HttpClient httpClient;

    @Test
    public void testGet(){
        System.out.println("=================="+httpClient);
        //
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/test/getUser");
        log.info("---------"+httpGet.getURI().toString());
        HttpResponse response;
        try {
            response = httpClient.execute(httpGet);
            System.out.println("------getStatusLine----------"+response.getStatusLine());
            HttpEntity entity = response.getEntity();
            if(entity!=null){
                System.out.println("--------getContentLength----------"+entity.getContentLength());
                System.out.println("--------entity----------"+entity);
                System.out.println("--------EntityUtils.toString----------"+EntityUtils.toString(entity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //if(response!=null){response.}
        }
    }

    @Test
    public void testPost(){
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/test/updateUser");
        log.info("---------"+httpPost.getURI().toString());
        // 创建参数队列
        List formparams = new ArrayList();
        formparams.add(new BasicNameValuePair("name","谢丽聪"));
        formparams.add(new BasicNameValuePair("age","18"));
        formparams.add(new BasicNameValuePair("sex","女"));
        formparams.add(new BasicNameValuePair("time",new Date().toString()));
        HttpResponse response;
        try {
            UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(formparams,"utf-8");
            httpPost.setEntity(encodedFormEntity);
            response = httpClient.execute(httpPost);
            System.out.println("------getStatusLine----------"+response.getStatusLine());
            HttpEntity entity = response.getEntity();
            if(entity!=null){
                System.out.println("--------getContentLength----------"+entity.getContentLength());
                System.out.println("--------entity----------"+entity);
                System.out.println("--------EntityUtils.toString----------"+EntityUtils.toString(entity));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
