package demo.thirdInterfacePay.huaxia.service.impl;

import demo.thirdInterfacePay.base.enums.Client;
import demo.thirdInterfacePay.base.enums.Service;
import demo.thirdInterfacePay.base.factory.FactoryBase;
import demo.thirdInterfacePay.base.factory.impl.ClientFactory;
import demo.thirdInterfacePay.huaxia.service.HuaxiaTransferServiceBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HuaxiaTransferServiceBaseImplTest {

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
    public void transfer() {
        map.put("PayCode", PayCode);
        map.put("PaySubAccount", subAccount);
        map.put("TradeMemCode", memBerCode);
        map.put("PayeesSubAccount", "20020180654812");
        map.put("TradeAccount", "1000");
        map.put("TradeCurrency", "CNY");
        FactoryBase factoryBase = new ClientFactory();
        HuaxiaTransferServiceBase service = (HuaxiaTransferServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.TRANSFER);
        System.out.println(service.transfer(map));
    }

    @Test
    public void transfers() {
        map.put("RequfileName", "BATCH_PAY_12111151_20180608153425_01.dat");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        map.put("BatchCode", sdf.format(new Date()));
        FactoryBase factoryBase = new ClientFactory();
        HuaxiaTransferServiceBase service = (HuaxiaTransferServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.TRANSFER);
        System.out.println(service.transfers(map));
    }

    @Test
    public void findTransfersResult() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        map.put("BatchPayCode", sdf.format(new Date()));
        FactoryBase factoryBase = new ClientFactory();
        HuaxiaTransferServiceBase service = (HuaxiaTransferServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.TRANSFER);
        System.out.println(service.findTransfersResult(map));
    }
}