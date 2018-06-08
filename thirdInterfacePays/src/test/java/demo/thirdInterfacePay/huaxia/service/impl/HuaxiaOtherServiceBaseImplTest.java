package demo.thirdInterfacePay.huaxia.service.impl;

import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.base.enums.Client;
import demo.thirdInterfacePay.base.enums.Service;
import demo.thirdInterfacePay.base.factory.FactoryBase;
import demo.thirdInterfacePay.base.factory.impl.ClientFactory;
import demo.thirdInterfacePay.huaxia.config.HuaxiaConfig;
import demo.thirdInterfacePay.huaxia.service.HuaxiaOtherServiceBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HuaxiaOtherServiceBaseImplTest {

    private Map<String, String> map;
    private String now;
    private String memBerCode = "0000007766";
    private String subAccount = "200201806944937";
    private String PayCode = "20180615688";
    private String TradeMemBerName = "金戈";

    @Before
    public void setUp() throws Exception {
        map = new HashMap<>(10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getMerchantPublicKey() {
        FactoryBase factoryBase = new ClientFactory();
        HuaxiaOtherServiceBase service = (HuaxiaOtherServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.OTHER);
        System.out.println(service.getMerchantPublicKey(map));
    }

    @Test
    public void changeDailyTradingNotification() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date time = new Date();
        map.put("EndDay", sdf.format(time));
        FactoryBase factoryBase = new ClientFactory();
        HuaxiaOtherServiceBase service = (HuaxiaOtherServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.OTHER);
        JsonResult jsonResult = service.changeDailyTradingNotification(map);
        System.out.println(jsonResult);
        if (jsonResult.getSuccess()) {
            HuaxiaConfig.begin = time.getTime();
            try {
                HuaxiaConfig.end = sdf.parse(sdf.format(time.getTime() + 24 * 60 * 60 * 1000)).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void findAccountBalance() {
        map.put("Account", subAccount);
        map.put("MemBerCode", memBerCode);
        map.put("AccountType", "1");
        FactoryBase factoryBase = new ClientFactory();
        HuaxiaOtherServiceBase service = (HuaxiaOtherServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.OTHER);
        System.out.println(service.findAccountBalance(map));
    }

    @Test
    public void findTradeDetail() {
        map.put("SubAccount", subAccount);
        map.put("MemBerCode", memBerCode);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        map.put("StartTimes", sdf.format(1528025000000L));
        map.put("EndTimes", sdf.format(new Date()));

        FactoryBase factoryBase = new ClientFactory();
        HuaxiaOtherServiceBase service = (HuaxiaOtherServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.OTHER);
        System.out.println(service.findTradeDetail(map));
    }

    @Test
    public void findPaymentOrderStatus() {
        map.put("PayCode", PayCode);
        FactoryBase factoryBase = new ClientFactory();
        HuaxiaOtherServiceBase service = (HuaxiaOtherServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.OTHER);
        System.out.println(service.findPaymentOrderStatus(map));
    }
}