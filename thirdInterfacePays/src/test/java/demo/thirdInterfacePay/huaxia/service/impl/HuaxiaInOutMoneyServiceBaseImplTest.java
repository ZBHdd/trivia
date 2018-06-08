package demo.thirdInterfacePay.huaxia.service.impl;

import demo.thirdInterfacePay.base.enums.Client;
import demo.thirdInterfacePay.base.enums.Service;
import demo.thirdInterfacePay.base.factory.FactoryBase;
import demo.thirdInterfacePay.base.factory.impl.ClientFactory;
import demo.thirdInterfacePay.huaxia.service.HuaxiaInOutMoneyServiceBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HuaxiaInOutMoneyServiceBaseImplTest {

    private Map<String, String> map;
    private String now;
    private String memBerCode = "0000007519";
    private String subAccount = "200626094";
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
    public void outMoneySelf() {
        map.put("SubAccount", subAccount);
        map.put("TradeMemCode", memBerCode);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        now = sdf.format(new Date());
        map.put("PayCode", now + new Random().nextInt(100000));
        map.put("OutComeMoney", "20");
        map.put("SumSubMoney", "22");
        map.put("OtherBankCost", "2");
        map.put("CusPayMoney", "1");
        map.put("MerOtherPayMoney", "1");
        map.put("OutAccount", "hdd");
        map.put("OutAccountName", "hdd");


        FactoryBase factoryBase = new ClientFactory();
        HuaxiaInOutMoneyServiceBase service = (HuaxiaInOutMoneyServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.INOUTMONEY);
        System.out.println(service.outMoneySelf(map));
    }

    @Test
    public void inMoneySelf() {
        map.put("SubAccount", subAccount);
        map.put("TradeMemCode", memBerCode);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        now = sdf.format(new Date());
        map.put("PayCode", now + new Random().nextInt(100000));

        map.put("InMoney", "2000");

        FactoryBase factoryBase = new ClientFactory();
        HuaxiaInOutMoneyServiceBase service = (HuaxiaInOutMoneyServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.INOUTMONEY);
        System.out.println(service.inMoneySelf(map));
    }

    @Test
    public void findOutMoneySelfData() {
        map.put("SubAccount", subAccount);
        map.put("OldOutComePayCode", PayCode);

        FactoryBase factoryBase = new ClientFactory();
        HuaxiaInOutMoneyServiceBase service = (HuaxiaInOutMoneyServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.INOUTMONEY);
        System.out.println(service.findOutMoneySelfData(map));
    }

    @Test
    public void trialFeeOther() {
        map.put("SubAccount", subAccount);
        map.put("TradeMemCode", memBerCode);
        map.put("CreMoney", "5000000");

        FactoryBase factoryBase = new ClientFactory();
        HuaxiaInOutMoneyServiceBase service = (HuaxiaInOutMoneyServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.INOUTMONEY);
        System.out.println(service.trialFeeOther(map));
    }

    @Test
    public void outOnlineBank() {
        map.put("SubAccount", subAccount);
        map.put("TradeMemCode", memBerCode);
        map.put("PayCode", PayCode);

        map.put("OutComeMoney", "20");
        map.put("SumSubMoney", "22");
        map.put("OtherBankCost", "2");
        map.put("CusPayMoney", "1");
        map.put("MerOtherPayMoney", "1");
        map.put("OutAccount", "123");
        map.put("OutAccountName", "hdd");
        map.put("TradeAbstract", "hdd");
        map.put("Remark1", "123");

        FactoryBase factoryBase = new ClientFactory();
        HuaxiaInOutMoneyServiceBase service = (HuaxiaInOutMoneyServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.INOUTMONEY);
        System.out.println(service.outOnlineBank(map));
    }

    @Test
    public void findInMoneyData() {
        map.put("SubAccount", subAccount);
        map.put("TradeMemCode", memBerCode);
        map.put("TradeMemBerName", TradeMemBerName);

        FactoryBase factoryBase = new ClientFactory();
        HuaxiaInOutMoneyServiceBase service = (HuaxiaInOutMoneyServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.INOUTMONEY);
        System.out.println(service.findInMoneyData(map));
    }

    @Test
    public void findToBeInMoneyData() {
        map.put("SubAccount", subAccount);
        map.put("TradeMemCode", memBerCode);

        FactoryBase factoryBase = new ClientFactory();
        HuaxiaInOutMoneyServiceBase service = (HuaxiaInOutMoneyServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.INOUTMONEY);
        System.out.println(service.findToBeInMoneyData(map));
    }
}