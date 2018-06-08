package demo.thirdInterfacePay.huaxia.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HuaxiaConfig {
    //华夏给的tomcat的ip:post或者url
    public static String url;
    public static String merchantNo;
    //日切的时间
    public static Long begin = 1528425000000L;
    public static Long end = 1528511400000L;
    public static String packages;

    static {
        Properties properties = new Properties();
        try {
            InputStream in = HuaxiaConfig.class.getResourceAsStream("/thirdpayConfig.properties");
            properties.load(in);
            HuaxiaConfig.url = properties.getProperty("url");
            HuaxiaConfig.merchantNo = properties.getProperty("merchantNo");
            HuaxiaConfig.packages = properties.getProperty("packages");
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
