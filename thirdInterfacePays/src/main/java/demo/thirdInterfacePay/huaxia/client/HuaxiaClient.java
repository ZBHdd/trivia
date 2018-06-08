package demo.thirdInterfacePay.huaxia.client;

import demo.thirdInterfacePay.base.client.ClientBase;
import demo.thirdInterfacePay.base.entry.JsonResult;
import demo.thirdInterfacePay.base.enums.Client;
import demo.thirdInterfacePay.base.enums.Service;
import demo.thirdInterfacePay.base.utils.ServiceUtils;
import demo.thirdInterfacePay.huaxia.base.HuaxiaBase;
import demo.thirdInterfacePay.huaxia.config.HuaxiaConfig;
import demo.thirdInterfacePay.huaxia.enums.Nodes;
import demo.thirdInterfacePay.huaxia.enums.ServiceCode;
import demo.thirdInterfacePay.huaxia.service.base.HuaxiaServiceBase;
import demo.thirdInterfacePay.huaxia.utils.HttpUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONObject;
import org.json.XML;

import java.text.SimpleDateFormat;
import java.util.*;

public class HuaxiaClient implements ClientBase, HuaxiaBase {
    //xml解析对象
    private Document xml;
    //xml字符串
    private String str;

    public HuaxiaClient() {
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String now = sdf.format(new Date());
        System.out.println(now);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Document getXml() {
        return xml;
    }

    public void setXml(Document xml) {
        this.xml = xml;
    }

    @Override
    public ClientBase newInstance() {
        return new HuaxiaClient();
    }

    @Override
    public HuaxiaServiceBase getService(Client client, Service service) {
        return (HuaxiaServiceBase) ServiceUtils.getService(client, service);
    }

    /**
     * 将xml对象转成str
     *
     * @return
     */
    public String formatXmlDoc() {
        return xml.asXML();
    }

    /**
     * 将str转成xml对象
     *
     * @return
     */
    public Document parseXmlStr() throws DocumentException {
        return parseXmlStr("<?xml version=\"1.0\" encoding=\"GBK\"?><CPMB2B><MessageData><Base><Version>1.0</Version><SignFlag>1</SignFlag><SeverModel>3</SeverModel></Base></MessageData></CPMB2B>");
    }

    public Document parseXmlStr(String text) throws DocumentException {
        return DocumentHelper.parseText(text);
    }

    /**
     * 生成一个节点，接口里只有data
     *
     * @param node 节点名称
     * @param data 数据
     */
    public String generateNode(String node, String data) {
        return String.format("<%s>%s</%s>", node, data, node);
    }

    /**
     * 查询节点的值，这是接口，一个节点名称只会查出一个节点
     *
     * @param node
     * @return
     */
    public String findChildData(Nodes node) {
        return this.findChild(node).getText();
    }

    public Element findChild(Nodes node) {
        return this.findChild(node.getName());
    }

    /**
     * 查询字符串（节点和子节点）
     *
     * @param node
     * @return
     */
    public String findChildStr(Nodes node) {
        return this.findChildStr(node.getName());
    }

    public String findChildStr(String node) {
        return this.findChild(node).asXML();
    }

    public Element findChild(String node) {
        List<Element> list = new ArrayList<>();
        list.add(this.xml.getRootElement());
        Element element;
        while (!list.isEmpty()) {
            element = list.get(0);
            if (element.elements(node).size() != 0) {
                return element.element(node);
            } else {
                list.addAll(element.elements());
            }
            list.remove(0);
        }
        return null;
    }

    /**
     * 添加节点
     *
     * @param node nodes 枚举对象
     * @param data 节点数据
     */
    public void addChild(Nodes node, String data) {
        while (true) {
            Element child = this.findChild(node.getpNode());
            if (child == null) {
                addChild(node.getpNode(), "");
            } else if (child.element(node.getName()) == null) {
                this.addChild(node.getName(), data, child);
            } else {
                return;
            }
        }
    }

    public void addChild(String node, String pNode, String data) {
        Element child = this.findChild(pNode);
        this.addChild(node, data, child);
    }

    /**
     * 添加节点
     *
     * @param node  节点名称
     * @param data  节点数据
     * @param child 父节点对象
     */
    public void addChild(String node, String data, Element child) {
        Element element = DocumentHelper.createElement(node);
        element.setText(data);
        List elements = child.elements(node);
        elements.add(0, element);
    }

    /**
     * 改变节点数据
     *
     * @param node 节点
     * @param data 数据
     */
    public void changeClild(String node, String data) {
        Element child = this.findChild(node);
        if (child != null) {
            child.setText(data);
        }
    }

    /**
     * 添加xml里的请求参数
     *
     * @param map  参数
     * @param code 接口代码
     */
    public void addData(Map<String, String> map, String code) throws DocumentException {
        this.addDataHeader(code);
        //添加商户代码
        this.addChild(Nodes.MERCHANTNO, HuaxiaConfig.merchantNo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date time = new Date();
        if (HuaxiaConfig.begin < time.getTime() && time.getTime() < HuaxiaConfig.end) {
            time.setTime(time.getTime() + 24 * 60 * 60 * 1000);
        }
        String now = sdf.format(time);
        this.addChild(Nodes.CLIENTTIME, now);
        //添加交易流水号
        this.addChild(Nodes.TRANSCODEIdREQ, now + code + new Random().nextInt(10000));
        //交易码
        this.addChild(Nodes.TRANSCODEREQ, code);
        this.addChild(Nodes.DATABODY, "");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.addChild(entry.getKey(), Nodes.DATABODY.getName(), entry.getValue());
        }
    }

    private void addDataHeader(String code) throws DocumentException {
        if (ServiceCode.GETMERCHANTPUBLICKEY.getCode().equals(code)) {
            this.xml = this.parseXmlStr("<?xml version=\"1.0\" encoding=\"GBK\"?><CPMB2B><MessageData><Base><Version>1.0</Version><SignFlag>0</SignFlag><SeverModel>3</SeverModel></Base></MessageData></CPMB2B>");
        } else {
            this.xml = this.parseXmlStr();
        }
    }

    /**
     * 读取响应信息
     *
     * @param msg
     * @return
     */
    public JsonResult paseResData(String msg) throws DocumentException {
        this.xml = this.parseXmlStr(msg);
        //获取响应码
        String code = this.findChildData(Nodes.CODE);
        JsonResult json = new JsonResult();
        if (!ServiceCode.SECCUSS.getCode().equals(code)) {
            json.setSuccess(false);
        } else {
            json.setSuccess(true);
        }
        //将xml转为json
        JSONObject xmlJSONObj = null;
        xmlJSONObj = XML.toJSONObject(this.findChildStr(Nodes.MESSAGEDATA));
        return json.setMsg(xmlJSONObj.toString()).setObj(xmlJSONObj).setCode(code);
    }

    /**
     * 调用接口(发送请求)
     *
     * @param map  参数
     * @param code 接口代码
     * @return
     */
    public JsonResult callInterfaceDetail(Map<String, String> map, String code) throws DocumentException {
        this.addData(map, code);
        System.out.println(this.formatXmlDoc());
        JsonResult json = HttpUtils.sendHttp(this.formatXmlDoc());
        if (!json.getSuccess()) {
            return json;
        } else {
            return this.paseResData(json.getMsg());
        }
    }

    public JsonResult callInterface(Map<String, String> map, String code) {
        try {
            return this.callInterfaceDetail(map, code);
        } catch (DocumentException e) {
            e.printStackTrace();
            return new JsonResult().setSuccess(false).setMsg("XML解析失败");
        }
    }
}