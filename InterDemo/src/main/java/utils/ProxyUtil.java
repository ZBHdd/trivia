package utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName ProxyUtil
 * @Description TODO
 * @Author Satan
 **/
public class ProxyUtil {

    public static void main(String args[])
    {
        StringBuffer sb = new StringBuffer();
        //创建HttpClient实例
        HttpClient client = getHttpClient();
        //创建httpGet
        HttpGet httpGet = new HttpGet("https://www.csdn.net");
        //执行
        try {
            HttpResponse response = client.execute(httpGet);

            HttpEntity entry = response.getEntity();

            if(entry != null)
            {
                InputStreamReader is = new InputStreamReader(entry.getContent());
                BufferedReader br = new BufferedReader(is);
                String str = null;
                while((str = br.readLine()) != null)
                {
                    sb.append(str.trim());
                }
                br.close();
            }

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

//设置代理

    public static HttpClient getHttpClient() {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        String proxyHost = "65.49.209.58";
        int proxyPort = 443;
        String userName = "443";
        String password = "jiaqifanhome";
        httpClient.getCredentialsProvider().setCredentials(
                new AuthScope(proxyHost, proxyPort),
                new UsernamePasswordCredentials(userName, password));
        HttpHost proxy = new HttpHost(proxyHost,proxyPort);
        httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
        return httpClient;
    }

}
