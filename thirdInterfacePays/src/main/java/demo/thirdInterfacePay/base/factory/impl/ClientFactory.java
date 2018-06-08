package demo.thirdInterfacePay.base.factory.impl;


import demo.thirdInterfacePay.base.base.Base;
import demo.thirdInterfacePay.base.client.ClientBase;
import demo.thirdInterfacePay.base.enums.Client;
import demo.thirdInterfacePay.base.factory.FactoryBase;
import demo.thirdInterfacePay.huaxia.config.HuaxiaConfig;

/**
 * 获取client对象
 */
public class ClientFactory implements FactoryBase, Base {

    /**
     * 获取client对象
     *
     * @param client
     * @return
     */
    @Override
    public ClientBase createClient(Client client) {
        try {
            String clientName = client.getName();
            return (ClientBase) Class.forName(HuaxiaConfig.packages
                    + "." + clientName.toLowerCase() + ".client." + clientName + "Client").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
