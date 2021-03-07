package main.java.com.gzmini.service;

import java.sql.Connection;
import javax.servlet.ServletContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import main.java.com.gzmini.common.Config;
import main.java.com.gzmini.common.SqlConnector;
import main.java.com.gzmini.bo.*;

public class Factory {

    private Config OCI;
    private Connection conn;

    /**
     * 构造函数
     * @param aApplication
     */
    public Factory(ServletContext aApplication) {
        OCI = new Config(aApplication);
    }
    public Factory() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        OCI = new Config(servletContext);
    }
    /**
     * 打开数据库联接
     * @throws Exception
     */
    public void openConnection()throws Exception{

        SqlConnector sqlconn = new SqlConnector(OCI);
        conn = sqlconn.getConnection();
    }

    /**
     * 关闭数据库联接
     *
     */
    public void colseConnection()
    {
        try{

            conn.close();
        }catch(Exception err)
        {
            System.out.println("closeJdbcData: "+err.getMessage());
        }

    }

    /**
     * 创建EnglishInfoBO对象
     * @return
     */

    public EnglishInfoBo createEnglishInfoBO()
    {
        return new EnglishInfoBo(conn);
    }
    public main.java.com.gzmini.bo.EnglishSentenceBo createEnglishSentenceBO()
    {
        return new main.java.com.gzmini.bo.EnglishSentenceBo(conn);
    }

}

