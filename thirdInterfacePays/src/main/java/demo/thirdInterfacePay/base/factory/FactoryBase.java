package demo.thirdInterfacePay.base.factory;


import demo.thirdInterfacePay.base.base.Base;
import demo.thirdInterfacePay.base.client.ClientBase;
import demo.thirdInterfacePay.base.enums.Client;

/**
 * 获取渠道对象
 */
public interface FactoryBase extends Base {
    /**
     * 创建渠道客户端
     *
     * @param client
     * @return
     */
    ClientBase createClient(Client client);
}
