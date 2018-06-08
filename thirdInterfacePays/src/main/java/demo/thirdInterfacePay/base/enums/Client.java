package demo.thirdInterfacePay.base.enums;

/**
 * 所有渠道
 * 利用反射获取具体Client
 */
public enum Client {
    //华夏
    HUAXIA("Huaxia");

    private String name;

    Client() {
    }

    Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
