package demo.thirdInterfacePay.base.service;

import demo.thirdInterfacePay.base.base.Base;
import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.base.service.base.ServiceBase;

import java.util.Map;

public interface InOutMoneyServiceBase extends Base, ServiceBase {

    /**
     * 提现
     * @param map 参数
     */
    JsonResult outMoneySelf(Map<String,String> map);

    /**
     * 充值
     * @param map 参数
     */
    JsonResult inMoneySelf(Map<String,String> map);

    /**
     * 查询提现详情
     * @param map 参数
     */
    JsonResult findOutMoneySelfData(Map<String,String> map);
}
