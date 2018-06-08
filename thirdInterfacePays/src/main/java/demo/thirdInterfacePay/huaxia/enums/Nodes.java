package demo.thirdInterfacePay.huaxia.enums;

/**
 * 接口里涉及的所有节点名称
 */
public enum Nodes {
    //root
    CPMB2B("CPMB2B", null),

    //一级
    MESSAGEDATA("MessageData", CPMB2B),

    //二级
    BASE("Base", MESSAGEDATA),

    //请求头信息
    REQHEADER("ReqHeader", MESSAGEDATA),

    //响应头信息
    RESHEADER("ResHeader", MESSAGEDATA),

    //报文体
    DATABODY("DataBody", MESSAGEDATA),

    //三级

    //客户端时间：YYYYMMDDHHMMSS
    CLIENTTIME("ClientTime", REQHEADER),

    //商户代码
    MERCHANTNO("MerchantNo", REQHEADER),

    //交易流水号
    TRANSCODEIdREQ("TransCodeId", REQHEADER),

    //交易码
    TRANSCODEREQ("TransCode", REQHEADER),

    //交易流水号
    TRANSCODEIdRES("TransCodeId", RESHEADER),

    //交易码
    TRANSCODERES("TransCode", RESHEADER),

    //响应信息状态
    STATUS("Status", RESHEADER),


    //四级

    //响应码
    CODE("Code", STATUS),

    //响应信息
    MESSAGE("Message", STATUS);


    private String name;
    private Nodes pNode;

    Nodes(String name, Nodes pNode) {
        this.name = name;
        this.pNode = pNode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nodes getpNode() {
        return pNode;
    }

    public void setpNode(Nodes pNode) {
        this.pNode = pNode;
    }
}
