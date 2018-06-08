package demo.thirdInterfacePay.huaxia.service.impl;

import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.huaxia.client.HuaxiaClient;
import demo.thirdInterfacePay.huaxia.enums.ServiceCode;
import demo.thirdInterfacePay.huaxia.service.HuaxiaInOutMoneyServiceBase;

import java.util.Map;

public class HuaxiaInOutMoneyServiceBaseImpl extends HuaxiaClient implements HuaxiaInOutMoneyServiceBase {
    @Override
    public JsonResult outMoneySelf(Map<String, String> map) {
        map.put("ChannelNo", "0000");
        map.put("OutComeAccountType", "0");
        return super.callInterface(map, ServiceCode.OUTMONEYSELF.getCode());
    }

    @Override
    public JsonResult inMoneySelf(Map<String, String> map) {
        return super.callInterface(map, ServiceCode.INMONEYSELF.getCode());
    }

    @Override
    public JsonResult findOutMoneySelfData(Map<String, String> map) {
        return super.callInterface(map, ServiceCode.FINDOUTMONEYSELFDATA.getCode());
    }

    @Override
    public JsonResult trialFeeOther(Map<String, String> map) {
        map.put("InOutMoneyType", "0");
        map.put("ChannelNo", "4000");
        return super.callInterface(map, ServiceCode.TRIALFEEOTHER.getCode());
    }

    @Override
    public JsonResult outOnlineBank(Map<String, String> map) {
        map.put("ChannelNo", "4000");
        map.put("OutComeAccountType", "0");
        return  super.callInterface(map, ServiceCode.OUTONLINEBANK.getCode());
    }

    @Override
    public JsonResult findInMoneyData(Map<String, String> map) {
        map.put("Currency", "CNY");
        return super.callInterface(map, ServiceCode.FINDINMONEYDATA.getCode());
    }

    @Override
    public JsonResult findToBeInMoneyData(Map<String, String> map) {
        map.put("Currency", "CNY");
        return super.callInterface(map, ServiceCode.FINDTOBEINMONEYDATA.getCode());
    }
}
