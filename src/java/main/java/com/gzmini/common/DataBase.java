package main.java.com.gzmini.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase
{
    protected Connection con;
    protected Statement stmt = null;		//Statement接口
    protected ResultSet rs = null;		//记录结果集
    protected PreparedStatement prepstmt = null;	//PreparedStatement接口，执行sql语句
    protected CallableStatement  cstmt = null;//CallableStatement接口，执行存储过程
}
