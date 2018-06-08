package demo.thirdInterfacePay.huaxia.service;

import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.base.service.InOutMoneyServiceBase;
import demo.thirdInterfacePay.huaxia.base.HuaxiaBase;
import demo.thirdInterfacePay.huaxia.service.base.HuaxiaServiceBase;

import java.util.Map;

public interface HuaxiaInOutMoneyServiceBase extends InOutMoneyServiceBase, HuaxiaServiceBase, HuaxiaBase {

    /**
     * 出入金手续费试算
     * @param map 参数
     */
    JsonResult trialFeeOther(Map<String,String> map);

    /**
     * 超级网银提现
     * @param map 参数
     */
    JsonResult outOnlineBank(Map<String,String> map);

    /**
     * 查询跨行转账充值电子账户
     * @param map 参数
     */
    JsonResult findInMoneyData(Map<String,String> map);

    /**
     * 转账充值待入账信息查询
     * @param map 参数
     */
    JsonResult findToBeInMoneyData(Map<String,String> map);


}
