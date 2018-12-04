package demo.thirdInterfacePay.huaxia.service.impl;


import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.huaxia.client.HuaxiaClient;
import demo.thirdInterfacePay.huaxia.enums.ServiceCode;
import demo.thirdInterfacePay.huaxia.service.HuaxiaAccountServiceBase;

import java.util.Map;

/**
 * @author Satan
 */
public class HuaxiaAccountServiceBaseImpl extends HuaxiaClient implements HuaxiaAccountServiceBase {

    @Override
    public JsonResult openAccount(Map<String, String> map) {
        map.put("Currency", "CNY");
        map.put("TradeMemBerGrade", "1");
        map.put("IsMessager", "2");
        return super.callInterface(map, ServiceCode.OPENACCOUNT.getCode());
    }

    @Override
    public JsonResult findAccountData(Map<String, String> map) {
        return super.callInterface(map, ServiceCode.FINDACCOUNTDATA.getCode());
    }

    @Override
    public JsonResult changeAccountStatus(Map<String, String> map) {
        map.put("IsCoerce", "1");
        return super.callInterface(map, ServiceCode.CHANGEACCOUNTSTATUS.getCode());
    }

    @Override
    public JsonResult settingsBankCard(Map<String, String> map) {
        map.put("StrideValidate", "0");
        map.put("CurrCode", "CNY");
        map.put("AccountSign", "0");
        map.put("IsSecondAcc", "0");
        map.put("LinkAccountType", "0");
        return super.callInterface(map, ServiceCode.SETTINGSBANKCARK.getCode());
    }

    @Override
    public JsonResult findBankCardData(Map<String, String> map) {
        map.put("OutComeAccountType", "0");
        return super.callInterface(map, ServiceCode.FINDBANKCARKDATA.getCode());
    }


}
