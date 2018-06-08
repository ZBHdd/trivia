package demo.thirdInterfacePay.huaxia.service;

import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.base.service.OtherServiceBase;
import demo.thirdInterfacePay.huaxia.base.HuaxiaBase;
import demo.thirdInterfacePay.huaxia.service.base.HuaxiaServiceBase;

import java.util.Map;

public interface HuaxiaOtherServiceBase extends OtherServiceBase, HuaxiaServiceBase, HuaxiaBase {
    /**
     * 获取商户公钥
     *
     * @param map 参数
     */
    JsonResult getMerchantPublicKey(Map<String, String> map);

    /**
     * 日切交易通知
     *
     * @param map 参数
     */
    JsonResult changeDailyTradingNotification(Map<String, String> map);

    /**
     * 账户余额查询
     *
     * @param map 参数
     */
    JsonResult findAccountBalance(Map<String, String> map);

    /**
     * 子账户交易明细查询
     *
     * @param map 参数
     */
    JsonResult findTradeDetail(Map<String, String> map);

    /**
     * 支付单状态查询
     *
     * @param map 参数
     */
    JsonResult findPaymentOrderStatus(Map<String, String> map);
}
