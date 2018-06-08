package demo.thirdInterfacePay.base.utils;


import demo.thirdInterfacePay.base.enums.Client;
import demo.thirdInterfacePay.base.enums.Service;
import demo.thirdInterfacePay.base.service.base.ServiceBase;
import demo.thirdInterfacePay.huaxia.config.HuaxiaConfig;

public class ServiceUtils {
    /**
     * 获取Service对象
     *
     * @param service
     * @return
     */
    public static ServiceBase getService(Client client, Service service) {
        try {
            String clientName = client.getName();
            return (ServiceBase) Class.forName(HuaxiaConfig.packages
                    + "." + clientName.toLowerCase() + ".service.impl." +
                    clientName + service.getName() + "ServiceBaseImpl").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
