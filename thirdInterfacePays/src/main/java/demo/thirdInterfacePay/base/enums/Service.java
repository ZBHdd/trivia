package demo.thirdInterfacePay.base.enums;

/**
 * ���жԽӵķ���
 */
public enum Service {
    //����
    ACCOUNT("Account"),
    INOUTMONEY("InOutMoney"),
    OTHER("Other"),
    TRANSFER("Transfer");

    private String name;

    Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
