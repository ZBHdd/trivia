import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupParseXml {
    /**
     * 添加节点
     * @param xml
     * @param node
     * @param parent
     * @return
     */
    public static Document addNode(Document xml, String node, String parent){
        if(xml ==null || node == null || parent == null) {
            return xml;
        }
        Element select = JsoupParseXml.findNode(xml, parent);
        if (select != null) {
            select.append(node);
        }
        return xml;
    }

    /**
     * 删除节点
     * @param xml
     * @param node
     * @return
     */
    public static Element delNode(Document xml, String node){
        if(xml ==null && node == null) {
            return null;
        }
        Element select = JsoupParseXml.findNode(xml, node);
        if(select != null){
            select.parent().html("");
        }
        return select;
    }

    /**
     * 查看节点
     * @param xml
     * @param node
     * @return
     */
    public static Element findNode(Document xml, String node){
        if(xml ==null || node == null){
            return null;
        }
        return xml.select(node).first();
    }

    /**
     * 查看子节点个数
     * @param xml
     * @param node
     * @return
     */
    public static int findClildNodes(Document xml, String node){
        if(xml ==null || node == null){
            return 0;
        }
        Element select = JsoupParseXml.findNode(xml, node);
        if(select == null){
            return 0;
        }
        return select.childNodeSize();
    }

    public static Element findPnode(Document xml, String node){
        if(xml ==null || node == null){
            return null;
        }
        Element select = JsoupParseXml.findNode(xml, node);
        if(select == null){
            return null;
        }
        return select.parent();
    }
}
