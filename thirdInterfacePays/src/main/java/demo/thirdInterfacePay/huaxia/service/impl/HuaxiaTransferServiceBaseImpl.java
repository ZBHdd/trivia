package demo.thirdInterfacePay.huaxia.service.impl;

import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.huaxia.client.HuaxiaClient;
import demo.thirdInterfacePay.huaxia.enums.ServiceCode;
import demo.thirdInterfacePay.huaxia.service.HuaxiaTransferServiceBase;

import java.util.Map;

public class HuaxiaTransferServiceBaseImpl extends HuaxiaClient implements HuaxiaTransferServiceBase {

    @Override
    public JsonResult transfer(Map<String, String> map) {
        return super.callInterface(map, ServiceCode.TRANSFER.getCode());
    }

    @Override
    public JsonResult transfers(Map<String, String> map) {
        return super.callInterface(map, ServiceCode.TRANSFERS.getCode());
    }

    @Override
    public JsonResult findTransfersResult(Map<String, String> map) {
        return super.callInterface(map, ServiceCode.FINDTRANSFERSRESULT.getCode());
    }
}
