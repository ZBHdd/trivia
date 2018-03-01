import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsoupParseXmlTest {
    private static String changeNode = "#487";
    private static String pNode = "#830";



    private static Document xml;
    private static String fileName = "src/test/resources/test.xml";
    private static String[] nodeNames = {"root","center","manager","accepter"};

    @BeforeAll
    static void start() {
        JsoupParseXmlTest jpxt = new JsoupParseXmlTest();
        jpxt.readXml();
    }

    @AfterAll
    static void  end() throws DocumentException, IOException {
        JsoupParseXmlTest jpxt = new JsoupParseXmlTest();
        jpxt.writeXml();
    }

    @Test
    void addNode() {
        Elements root;
        do {
            int i = (int) (Math.random() * nodeNames.length);
            root = xml.select(nodeNames[i]);
        } while (root.size() == 0);

        String pNode = root.eq((int) (Math.random() * root.size())).first().nodeName();
        Element node = JsoupParseXml.addNode(xml, generateNode(pNode), pNode);
        assertNotNull(node, "没找到该内容的节点：" + JsoupParseXmlTest.changeNode);
    }

    @Test
    void delNode() {
        String s = JsoupParseXml.delNode(xml, JsoupParseXmlTest.changeNode);
        assertNotNull(s,"没找到该内容的节点："+JsoupParseXmlTest.changeNode);
    }

    @Test
    void findNode() {
        Elements nodes = JsoupParseXml.findNode(xml, JsoupParseXmlTest.changeNode);
        assertNotNull(nodes,"没找到该内容的节点："+JsoupParseXmlTest.changeNode);
    }

    @Test
    void findClildNodes() {
        JsoupParseXml.findClildNodes(xml, changeNode+" "+nodeNames[2]);
    }

    @Test
    void findPnode() {
        Element pnode = JsoupParseXml.findPnode(xml, nodeNames[0]);
        assertTrue(pnode.nodeName().equals("body"));
    }

    @Test
    void moveNode(){
        String del = JsoupParseXml.delNode(xml, JsoupParseXmlTest.changeNode);
        JsoupParseXml.addNode(xml,del,JsoupParseXmlTest.pNode);
    }

    private void readXml() {
        File file = new File(fileName);
        try {
            xml = Jsoup.parse(file,"UTF-8");
        } catch (IOException e) {
            xml = Jsoup.parse("<"+nodeNames[0]+"/>");
        }
        assertNotNull(xml,"xml 不能为空:"+fileName);
    }

    private void  writeXml() throws DocumentException, IOException {
        //输出全部原始数据，在编译器中显示
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");//根据需要设置编码
        XMLWriter writer = new XMLWriter(System.out, format);
        String html = xml.html();
        if(html.contains("<!--?xml version=\"1.0\" encoding=\"UTF-8\"?-->")){
            html = html.substring(html.lastIndexOf("-->")+3);
        }
        org.dom4j.Document document = DocumentHelper.parseText(html);
        document.normalize();
        writer.write(document);
        writer.close();
        // 输出全部原始数据，并用它生成新的我们需要的XML文件
        XMLWriter writer2 = new XMLWriter(new FileWriter(new File(fileName)), format);
        writer2.write(document); //输出到文件
        writer2.close();
    }

    private static String generateNode(String pNode){
        for(int i =0;i<nodeNames.length;i++){
            if(nodeNames[i].equals(pNode)){
                if(i+1 == nodeNames.length){
                    i--;
                }
                return "<"+nodeNames[i+1]+" id='"+generateId()+"'/>";
            }
        }
        return null;
    }

    private static int generateId(){
        int id;
        do {
            id = (int)(Math.random()*1000);
        }while (xml.select("#"+id) == null);
        return id;
    }
}