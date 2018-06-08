package demo.thirdInterfacePay.huaxia.utils;

import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.huaxia.config.HuaxiaConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {
    /**
     * ��������
     */
    public static JsonResult sendHttp(String param) {
        String url = "http://" + HuaxiaConfig.url + "/ClientV1.0/http/MerchantRequestProcees";
        URL u = null;
        HttpURLConnection c = null;
        StringBuffer sbf = new StringBuffer();
        try {
            u = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return new JsonResult().setSuccess(false).setMsg("url���󴴽�ʧ��,��������·��");
        }
        try {
            c = (HttpURLConnection) u.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult().setSuccess(false).setMsg("url���Ӷ��󴴽�ʧ��");
        }
        c.setRequestProperty("Accept", "*/*");
        c.setRequestProperty("Connection", "keep-alive");
        c.setRequestProperty("User-Agent", "Java/1.7");
        c.setDoInput(true);
        c.setDoOutput(true);
        PrintWriter p = null;
        try {
            p = new PrintWriter(c.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult().setSuccess(false).setMsg("��ȡURL���Ӷ����Ӧ�������ʧ��");
        }
        p.print(param);
        p.flush();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String tLine;
            while ((tLine = br.readLine()) != null) {
                sbf.append(tLine);
                if (tLine.contains("</CPMB2B>")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult().setSuccess(false).setMsg("��ȡURL����Ӧʧ��");
        } finally {
            p.close();
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new JsonResult().setSuccess(true).setMsg(sbf.toString());
    }
}
