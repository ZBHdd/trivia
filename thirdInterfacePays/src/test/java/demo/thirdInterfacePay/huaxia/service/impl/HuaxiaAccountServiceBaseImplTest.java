package demo.thirdInterfacePay.huaxia.service.impl;

import demo.thirdInterfacePay.base.enums.Client;
import demo.thirdInterfacePay.base.enums.Service;
import demo.thirdInterfacePay.base.factory.FactoryBase;
import demo.thirdInterfacePay.base.factory.impl.ClientFactory;
import demo.thirdInterfacePay.huaxia.service.HuaxiaAccountServiceBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HuaxiaAccountServiceBaseImplTest {

    private Map<String, String> map;
    private String now;
    private String memBerCode = "0000007814";
    private String subAccount = "20020180654812";

    @Before
    public void setUp() throws Exception {
        map = new HashMap<>(10);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 开户，PapersType（10 身份证，16营业执照）TradeMemberProperty（0企业，1个人）
     */
    @Test
    public void openAccount() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        now = sdf.format(new Date());
        map.put("TradeMemBerName", "王铮");
        map.put("SubAcc", "200" + now + new Random().nextInt(1000000));
        map.put("BoothNo", "100100343400");

        map.put("Email", "cbotwzh@163.com");
        map.put("TradeMemberProperty", "1");
        map.put("PapersType", "10");
        map.put("PapersCode", "370602197811244318");
        if("0".equals(map.get("TradeMemberProperty"))){
            map.put("PapersType", "16");
            map.put("PapersCode", "370602197811244318");
            map.put("Contact", map.get("TradeMemBerName"));
            map.put("ContactPhone", "18538706070");
            map.put("Phone", map.get("ContactPhone"));
            map.put("ContactAddr", "北京市东城区");
            map.put("BusinessName", "18538706070");
        }
        FactoryBase factoryBase = new ClientFactory();
        HuaxiaAccountServiceBase service = (HuaxiaAccountServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.ACCOUNT);
        System.out.println(service.openAccount(map));
    }

    /**
     * 账号信息查询
     */
    @Test
    public void findAccountData() {
        map.put("MemBerCode", memBerCode);
        FactoryBase factoryBase = new ClientFactory();
        HuaxiaAccountServiceBase service = (HuaxiaAccountServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.ACCOUNT);
        System.out.println(service.findAccountData(map));
    }

    /**
     * 修改账号状态 0正常，1禁用，2销户
     */
    @Test
    public void changeAccountStatus1() {
        map.put("SubAccount", subAccount);
        map.put("TradeMemCode", memBerCode);
        map.put("State", "1");
        FactoryBase factoryBase = new ClientFactory();
        HuaxiaAccountServiceBase service = (HuaxiaAccountServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.ACCOUNT);
        System.out.println(service.changeAccountStatus(map));
    }


    /**
     * 设置绑卡的银行卡信息，（1绑卡，2修改，3解绑）IsOther（1公,2私）IsOtherBank(0华夏，1其他银行)
     */
    @Test
    public void settingsBankCard() {
        map.put("OperType", "1");
        map.put("SubAccount", subAccount);
        map.put("TradeMemCode", memBerCode);
        map.put("IsOther", "2");
        map.put("IsOtherBank", "0");
        map.put("SettleAccountName", "2");
        map.put("SettleAccount", "2");

        map.put("PapersType", "10");
        map.put("PapersCode", "370602197811244318");

        FactoryBase factoryBase = new ClientFactory();
        HuaxiaAccountServiceBase service = (HuaxiaAccountServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.ACCOUNT);
        System.out.println(service.settingsBankCard(map));
    }

    /**
     * 查询绑卡信息
     */
    @Test
    public void findBankCardData() {
        map.put("SubAccount", subAccount);
        map.put("TradeMemCode", memBerCode);

        FactoryBase factoryBase = new ClientFactory();
        HuaxiaAccountServiceBase service = (HuaxiaAccountServiceBase) factoryBase
                .createClient(Client.HUAXIA).getService(Client.HUAXIA, Service.ACCOUNT);
        System.out.println(service.findBankCardData(map));
    }
}