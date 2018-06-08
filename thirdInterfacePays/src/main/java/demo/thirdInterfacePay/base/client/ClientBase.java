package demo.thirdInterfacePay.base.client;

import demo.thirdInterfacePay.base.base.Base;
import demo.thirdInterfacePay.base.enums.Client;
import demo.thirdInterfacePay.base.enums.Service;
import demo.thirdInterfacePay.base.service.base.ServiceBase;

public interface ClientBase extends Base {
    ClientBase newInstance();


    ServiceBase getService(Client client, Service service);
}
