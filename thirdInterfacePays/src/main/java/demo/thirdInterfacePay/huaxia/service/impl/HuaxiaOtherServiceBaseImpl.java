package demo.thirdInterfacePay.huaxia.service.impl;

import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.huaxia.client.HuaxiaClient;
import demo.thirdInterfacePay.huaxia.enums.ServiceCode;
import demo.thirdInterfacePay.huaxia.service.HuaxiaOtherServiceBase;

import java.util.Map;

public class HuaxiaOtherServiceBaseImpl extends HuaxiaClient implements HuaxiaOtherServiceBase {
    @Override
    public JsonResult getMerchantPublicKey(Map<String, String> map) {
        map.put("Key", "");
        return super.callInterface(map, ServiceCode.GETMERCHANTPUBLICKEY.getCode());
    }

    @Override
    public JsonResult changeDailyTradingNotification(Map<String, String> map) {
        return super.callInterface(map, ServiceCode.CHANGEDAILYTRADINGNOTIFICATION.getCode());
    }

    @Override
    public JsonResult findAccountBalance(Map<String, String> map) {
        return super.callInterface(map, ServiceCode.FINDACCOUNTBALANCE.getCode());
    }

    @Override
    public JsonResult findTradeDetail(Map<String, String> map) {
        return super.callInterface(map, ServiceCode.FINDTRADETAIL.getCode());
    }

    @Override
    public JsonResult findPaymentOrderStatus(Map<String, String> map) {
        return super.callInterface(map, ServiceCode.FINDPAYMENTORDERSTATUS.getCode());
    }
}
