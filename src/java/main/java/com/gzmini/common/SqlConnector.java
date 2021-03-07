package main.java.com.gzmini.common;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class SqlConnector {

    private Config OC = null;
    private java.sql.Connection Conn;

    private String Password = "";

    private String User = "";

    private String Database = "";

    private String Server = "";

    private String Type = "";

    private String Encode = "";

    /**
     * 构造方法
     *
     * @param aOC
     *            配置文件
     * @throws Exception
     */
    public SqlConnector(Config aOC) throws Exception {
        OC = aOC;
        Password = OC.getParameter("data-password");
        User = OC.getParameter("data-user");
        Database = OC.getParameter("database");
        Server = OC.getParameter("data-server");
        Type = OC.getParameter("database-type");
        Encode = OC.getParameter("encode");
    }

    /**
     * 取出数据库连接
     *
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        if ("mysql".equals(Type)) {
            // mysql 数据库连接
            return getMysqlConn();
        } else if ("oracle".equals(Type)) {
            // oracle数据库连接
            return getOracleConn();
        } else if ("oraclepool".equals(Type)) {
            // oracle数据库连接池
            return getOraclePoolConn();
        } else {
            // MS SQL 数据库连接
            return getMsSqlConn();
        }

    }

    /**
     * mysql数据库连接
     *
     * @return
     * @throws Exception
     */
    private Connection getMysqlConn() throws Exception {
        String tParam = "jdbc:mysql://" + Server + "/" + Database + "?user="
                + User + "&password=" + Password;

        if ("false".equals(Encode)) {
        } else {
            tParam = tParam + "&useUnicode=true&characterEncoding=GBK";
        }
        //Class.forName("org.gjt.mm.mysql.Driver");
        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Conn = java.sql.DriverManager.getConnection(tParam);
        return Conn;
    }

    /**
     * Oracle 数据库连接
     *
     * @return
     * @throws Exception
     */
    private Connection getOracleConn() throws Exception {

        String tParam = "jdbc:oracle:thin:@" + Server + ":1521:" + Database;
        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        Conn = java.sql.DriverManager.getConnection(tParam, User, Password);

        return Conn;
    }

    /**
     * Oracle 数据库连接池
     *
     * @return
     * @throws Exception
     */
    private Connection getOraclePoolConn() throws Exception {
        if (Conn == null) {
            try {
                javax.sql.DataSource tDS = null;
                Context tContext = new InitialContext();

                // 网上例子
                // javax.sql.DataSource
                // ds=(javax.sql.DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
                // java.sql.Connection conn = ds.getConnection("gjq","123");

                tDS = (DataSource) tContext.lookup(Database);

                Conn = tDS.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
                throw e;

            }
        }
        return Conn;
    }

    /**
     * MSSQL数据库连接
     *
     * @return
     * @throws Exception
     */
    private Connection getMsSqlConn() throws Exception {

        String tParam = "jdbc:microsoft:sqlserver://" + Server
                + ":1433;DatabaseName=" + Database;
        Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
        Conn = java.sql.DriverManager.getConnection(tParam, User, Password);

        return Conn;

    }

    /**
     * 释放连接
     *
     * @throws Exception
     */
    public void freeConnection() throws Exception {
        if (Conn != null) {
            Conn.close();
            Conn = null;
        }
    }
}

