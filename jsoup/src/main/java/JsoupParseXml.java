import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
        Element select = JsoupParseXml.findNode(xml, parent).first();
        if (select != null) {
            select.append(node);
        }
        return xml;
    }

    /**
     * 删除节点
     * @param xml 解析xml得到的对象
     * @param node 节点
     * @return 删除的内容
     */
    public static String delNode(Document xml, String node){
        if(xml ==null && node == null) {
            return null;
        }
        Elements select = JsoupParseXml.findNode(xml, node);
        String del = null;
        if(select != null){
            del = select.first().parent().html();
            select.first().parent().html("");
        }
        return del;
    }

    /**
     * 查看节点
     * @param xml 解析xml得到的对象
     * @param node 节点
     * @return
     */
    public static Elements findNode(Document xml, String node){
        if(xml ==null || node == null){
            return null;
        }
        return xml.select(node);
    }

    /**
     * 利用 组合选择器 查看子节点个数
     * @param xml
     * @param node
     * @return
     */
    public static int findClildNodes(Document xml, String node){
        if(xml ==null || node == null){
            return 0;
        }
        Elements selects = JsoupParseXml.findNode(xml, node);
        if(selects.size() == 0){
            return 0;
        }
        return selects.size();
    }

    public static Element findPnode(Document xml, String node){
        if(xml ==null || node == null){
            return null;
        }
        Element select = JsoupParseXml.findNode(xml, node).first();
        if(select == null){
            return null;
        }
        return select.parent();
    }
}
