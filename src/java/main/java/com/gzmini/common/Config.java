package main.java.com.gzmini.common;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;




/**
 * 配置文件处理
 *
 */
public class Config  {
    private javax.servlet.ServletContext  App=null;
    private Document Doc=null;

    public Config(String aFilePath) throws Exception {
        this.setConfigDoc(aFilePath);
    }

    public Config(javax.servlet.ServletContext aApplication){
        App=aApplication;
    }

    /**
     * 取参数值
     *
     * @param name
     * @return
     * @throws Exception
     */
    public String getParameter(String name)
            throws Exception
    {
        if (App != null)
            return App.getInitParameter(name);

        if (Doc != null)
            return this.getElementValue(this.getElement(Doc, name));

        throw new Exception("传入的App对象为空或配置文件不存在.");
    }

    protected void setConfigDoc(String aFilePath) throws Exception{
        DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
        // Set namespaceAware to true to get a DOM Level 2 tree with nodes
        // containing namesapce information.  This is necessary because the
        // default value from JAXP 1.0 was defined to be false.
        dbf.setNamespaceAware(true);

        // Step 2: create a DocumentBuilder that satisfies the constraints
        // specified by the DocumentBuilderFactory
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Step 3: parse the input file
        Doc = db.parse(new File(aFilePath));
    }


    protected void cloneConfig(Config aConfig) throws Exception{
        if (aConfig.getApp()!=null) {
            this.App=aConfig.getApp();
        }

        if (aConfig.getDoc()!=null) {
            this.Doc=aConfig.getDoc();
        }
    }

    private String getElementValue(Node aNode){
        String tValue=null;
        if(aNode.getNodeType()==Node.TEXT_NODE){
            return aNode.getNodeValue();
        }else{
            for (Node child = aNode.getFirstChild(); child != null;
                 child = child.getNextSibling()) {
                tValue=getElementValue(child);
                if (tValue!=null) {
                    return tValue;
                }
            }
            return null;
        }
    }

    private Node getElement(Node aNode,String aName){
        //int type = aNode.getNodeType();
        Node tNode=null;
        if(aNode.getNodeType()==Node.ELEMENT_NODE && aNode.getNodeName().equals(aName)){
            return aNode;
        }else{
            for (Node child = aNode.getFirstChild(); child != null;
                 child = child.getNextSibling()) {
                tNode=getElement(child,aName);
                if (tNode!=null) {
                    return tNode;
                }
            }
            return null;
        }
    }


    /**
     * 取出素材库文件保存相对路径
     * @return
     * @throws Exception
     */
    public String  getRelativePath() throws Exception
    {
        return this.getParameter("relative-path");
    }


    /**
     * 取出素材库文件保存绝对路径
     * @return
     * @throws Exception
     */
    public String  getAbsolutePath() throws Exception
    {
        return this.getParameter("absolute-path");
    }


    public Document getDoc()
    {
        return Doc;
    }

    public void setDoc(Document Doc)
    {
        this.Doc = Doc;
    }

    public javax.servlet.ServletContext getApp()
    {
        return App;
    }

    public void setApp(javax.servlet.ServletContext App)
    {
        this.App = App;
    }

    private String appDataPath;
    /**
     * 取得应用程序保存数据的路径
     *
     * @return
     * @throws Exception
     */
    public String getAppDataPath()
            throws Exception
    {
        if (this.appDataPath == null)
        {
            this.appDataPath = getParameter("file-store-path");

            if (!this.appDataPath.endsWith(File.separator))
                this.appDataPath += File.separator;
        }

        return this.appDataPath;
    }


}

