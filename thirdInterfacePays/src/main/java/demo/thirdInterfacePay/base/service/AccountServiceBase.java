package demo.thirdInterfacePay.base.service;


import demo.thirdInterfacePay.base.base.Base;
import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.base.service.base.ServiceBase;

import java.util.Map;

public interface AccountServiceBase extends Base, ServiceBase {
    /**
     * 开户
     *
     * @param map 参数
     * @return
     */
    JsonResult openAccount(Map<String, String> map);

    /**
     * 账号信息查询
     *
     * @param map 参数
     * @return
     */
    JsonResult findAccountData(Map<String, String> map);

    /**
     * 修改账号状态
     *
     * @param map 参数
     * @return
     */
    JsonResult changeAccountStatus(Map<String, String> map);

    /**
     * 设置绑卡的银行卡信息，（绑卡，解绑，修改）
     * @param map
     * @return
     */
    JsonResult settingsBankCard(Map<String, String> map);

    /**
     * 查询绑卡信息
     * @param map
     * @return
     */
    JsonResult findBankCardData(Map<String, String> map);
}
