package demo.thirdInterfacePay.base.service;


import demo.thirdInterfacePay.base.base.Base;
import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.base.service.base.ServiceBase;

import java.util.Map;

public interface TransferServiceBase extends Base, ServiceBase {

    /**
     * 支付交易
     *
     * @param map 参数
     * @return
     */
    JsonResult transfer(Map<String, String> map);

    /**
     * 批量支付
     *
     * @param map 参数
     * @return
     */
    JsonResult transfers(Map<String, String> map);

    /**
     * 批量支付结果查询
     *
     * @param map 参数
     * @return
     */
    JsonResult findTransfersResult(Map<String, String> map);
}
