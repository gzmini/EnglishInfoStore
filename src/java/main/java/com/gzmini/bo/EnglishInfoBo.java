package main.java.com.gzmini.bo;

import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Collection;
import main.java.com.gzmini.vo.EnglishInfoVo;
import main.java.com.gzmini.common.DataBase;

public class EnglishInfoBo extends DataBase
{
    public EnglishInfoBo(Connection acon){

        this.con =acon;
    }

    public int NewWord(EnglishInfoVo englishinfovo) throws Exception
    {
        int o_Result = 0;
        try
        {
            this.cstmt = this.con.prepareCall("{call NewWord(?,?,?)}");
            this.cstmt.setString(1,englishinfovo.getWordname());
            this.cstmt.setString(2,englishinfovo.getWorddescribe());
            this.cstmt.registerOutParameter(3, Types.INTEGER);
            this.cstmt.execute();
            o_Result = this.cstmt.getInt(3);

            //this.cstmt.executeUpdate();
            //String Sql = "insert into tb_user(username) Values('"+ testvo.getUsername() +"')";
            //this.prepstmt = this.con.prepareStatement(Sql);
            //this.prepstmt.executeUpdate();
        }
        catch(Exception err)
        {
            err.printStackTrace();
            throw err;

        }
        finally
        {

            if (this.cstmt != null)
                this.cstmt.close();
        }
        return o_Result;
    }

    public void UpdateWord(EnglishInfoVo englishinfovo) throws Exception
    {
        try
        {
            this.cstmt = this.con.prepareCall("{call UpdateWord(?,?,?)}");
            this.cstmt.setInt(1,englishinfovo.getId());
            this.cstmt.setString(2,englishinfovo.getWorddescribe());
            this.cstmt.registerOutParameter(3, Types.INTEGER);
            this.cstmt.execute();
            //String Sql = "update tb_user set username='"+ testvo.getUsername() +"' where id="+testvo.getId();
            //this.prepstmt = this.con.prepareStatement(Sql);
            //this.prepstmt.executeUpdate();
        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.cstmt != null)
                this.cstmt.close();
        }
    }

    public void DeleteWord(int id) throws Exception
    {
        try
        {
            this.cstmt = this.con.prepareCall("{call DeleteWord(?,?)}");
            this.cstmt.setInt(1,id);
            this.cstmt.registerOutParameter(2, Types.INTEGER);
            this.cstmt.execute();
            int o_Result = this.cstmt.getInt(2);
            if (o_Result != 0)
            {
                o_Result = -1;
            }
            //String Sql = "delete from tb_user where id="+id;
            //this.prepstmt = this.con.prepareStatement(Sql);
            //this.prepstmt.executeUpdate();

        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.cstmt != null)
                this.cstmt.close();
        }
    }

    public void IncreaseSearchNum(String wordname) throws Exception
    {
        try
        {
            this.cstmt = this.con.prepareCall("{call IncreaseSearchNum(?,?)}");
            this.cstmt.setString(1,wordname);
            this.cstmt.registerOutParameter(2, Types.INTEGER);
            this.cstmt.execute();
            int o_Result = this.cstmt.getInt(2);
        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.cstmt != null)
                this.cstmt.close();
        }
    }

    public Collection<EnglishInfoVo> getEnglishInfoList_Collection() throws Exception
    {
        Collection<EnglishInfoVo> englishinfoList = new ArrayList<EnglishInfoVo>();
        String Sql = "select * from TB_WORD order by wordname";
        try
        {
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            while (rs != null && rs.next())
            {
                EnglishInfoVo englishinfovo = new EnglishInfoVo();
                englishinfovo.setId(rs.getInt("id"));
                englishinfovo.setWordname(rs.getString("wordname"));
                englishinfovo.setWorddescribe(rs.getString("worddescribe"));
                englishinfovo.setNewtime(rs.getString("newtime"));
                englishinfovo.setSearchnum(rs.getInt("searchnum"));
                englishinfoList.add(englishinfovo);
            }
            return englishinfoList;
        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.stmt != null)
                this.stmt.close();
        }

    }

    public Vector<EnglishInfoVo> getEnglishInfoList_Vector() throws Exception
    {
        Vector<EnglishInfoVo> englishinfoList = new Vector<EnglishInfoVo>();
        String Sql = "select * from TB_WORD order by wordname";
        try
        {
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            while (rs != null && rs.next())
            {
                EnglishInfoVo englishinfovo = new EnglishInfoVo();
                englishinfovo.setId(rs.getInt("id"));
                englishinfovo.setWordname(rs.getString("wordname"));
                englishinfovo.setWorddescribe(rs.getString("worddescribe"));
                englishinfovo.setNewtime(rs.getString("newtime"));
                englishinfovo.setSearchnum(rs.getInt("searchnum"));
                englishinfoList.add(englishinfovo);
            }
            return englishinfoList;
        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.stmt != null)
                this.stmt.close();
        }

    }

    public List<EnglishInfoVo> getEnglishInfoList_List() throws Exception
    {
        List<EnglishInfoVo> englishinfoList = new ArrayList<EnglishInfoVo>();
        String Sql = "select * from TB_WORD order by wordname";
        try
        {
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            while (rs != null && rs.next())
            {
                EnglishInfoVo englishinfovo = new EnglishInfoVo();
                englishinfovo.setId(rs.getInt("id"));
                englishinfovo.setWordname(rs.getString("wordname"));
                englishinfovo.setWorddescribe(rs.getString("worddescribe"));
                englishinfovo.setNewtime(rs.getString("newtime"));
                englishinfovo.setSearchnum(rs.getInt("searchnum"));
                englishinfoList.add(englishinfovo);
            }
            return englishinfoList;
        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.stmt != null)
                this.stmt.close();
        }

    }
    public List<String> getEnglishInfoList_ListString() throws Exception
    {
        List<String> englishinfoList = new ArrayList<String>();
        String Sql = "select * from TB_WORD order by wordname";
        try
        {

            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            while (rs != null && rs.next())
            {
                englishinfoList.add(rs.getString("wordname"));
            }
            return englishinfoList;
        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.stmt != null)
                this.stmt.close();
        }

    }


    public EnglishInfoVo getEnglishInfoById(int id) throws Exception
    {

        String Sql = "select * from TB_WORD where id=" + id;
        try
        {
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            EnglishInfoVo englishinfovo = new EnglishInfoVo();
            if (rs != null && rs.next())
            {
                englishinfovo.setId(rs.getInt("id"));
                englishinfovo.setWordname(rs.getString("wordname"));
                englishinfovo.setWorddescribe(rs.getString("worddescribe"));
            }
            return englishinfovo;
        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.stmt != null)
                this.stmt.close();
        }

    }

    public int getEnglishInfoCount() throws Exception
    {

        String Sql = "select count(*) counts from TB_WORD";
        int count = 0;
        try
        {
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            if (rs != null && rs.next())
            {

                count = rs.getInt("counts");
            }
            return count;
        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.stmt != null)
                this.stmt.close();
        }

    }

    public List<EnglishInfoVo> getEnglishInfoByWordName(String wordname) throws Exception
    {
        this.IncreaseSearchNum(wordname);
        List<EnglishInfoVo> englishinfoList = new ArrayList<EnglishInfoVo>();
        String Sql = "select * from TB_WORD where wordname='" + wordname +"'";
        try
        {
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            if (rs != null && rs.next())
            {
                EnglishInfoVo englishinfovo = new EnglishInfoVo();
                englishinfovo.setId(rs.getInt("id"));
                englishinfovo.setWordname(wordname);
                englishinfovo.setWorddescribe(rs.getString("worddescribe"));
                englishinfovo.setNewtime(rs.getString("newtime"));
                englishinfovo.setSearchnum(rs.getInt("searchnum"));
                englishinfoList.add(englishinfovo);
            }
            return englishinfoList;
        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.stmt != null)
                this.stmt.close();
        }

    }

    public Vector<EnglishInfoVo> getEnglishInfoByWordDescribe(String worddescribe) throws Exception
    {
        Vector<EnglishInfoVo> englishinfoList = new Vector<EnglishInfoVo>();
        String Sql = "select * from TB_WORD where worddescribe like '%" + worddescribe + "%' order by newtime ";
        try
        {
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            while (rs != null && rs.next())
            {
                EnglishInfoVo englishinfovo = new EnglishInfoVo();
                englishinfovo.setId(rs.getInt("id"));
                englishinfovo.setWordname(rs.getString("wordname"));
                englishinfovo.setWorddescribe(rs.getString("worddescribe"));
                englishinfovo.setNewtime(rs.getString("newtime"));
                englishinfovo.setSearchnum(rs.getInt("searchnum"));
                englishinfoList.add(englishinfovo);
            }
            return englishinfoList;
        }
        catch(Exception err)
        {
            throw err;

        }
        finally
        {

            if (this.stmt != null)
                this.stmt.close();
        }

    }
}

