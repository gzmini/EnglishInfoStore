package main.java.com.gzmini.bo;

import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import main.java.com.gzmini.vo.EnglishSentenceVo;
import main.java.com.gzmini.common.DataBase;


public class EnglishSentenceBo extends DataBase {

    public EnglishSentenceBo(Connection acon){

        this.con =acon;
    }
    public int NewSentence(EnglishSentenceVo englishsentencevo) throws Exception
    {
        int o_Result = 0;
        try
        {
            this.cstmt = this.con.prepareCall("{call NewSentence(?,?)}");
            this.cstmt.setString(1,englishsentencevo.getSentence());
            this.cstmt.registerOutParameter(2, Types.INTEGER);
            this.cstmt.execute();
            o_Result = this.cstmt.getInt(2);
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
        return o_Result;
    }
    public void UpdateSentence(EnglishSentenceVo englishsentencevo) throws Exception
    {
        try
        {
            this.cstmt = this.con.prepareCall("{call UpdateSentence(?,?,?)}");
            this.cstmt.setInt(1,englishsentencevo.getId());
            this.cstmt.setString(2,englishsentencevo.getSentence());
            this.cstmt.registerOutParameter(3, Types.INTEGER);
            this.cstmt.execute();
            int o_Result = this.cstmt.getInt(3);
            if (o_Result != 0)
            {
                o_Result = -1;
            }
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

    public void DeleteSentence(int id) throws Exception
    {
        try
        {
            this.cstmt = this.con.prepareCall("{call DeleteSentence(?,?)}");
            this.cstmt.setInt(1,id);
            this.cstmt.registerOutParameter(2, Types.INTEGER);
            this.cstmt.execute();
            int o_Result = this.cstmt.getInt(2);
            if (o_Result != 0)
            {
                o_Result = -1;
            }
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

    public EnglishSentenceVo getEnglishSentenceById(int id) throws Exception
    {

        String Sql = "select * from TB_SENTENCE where id=" + id;
        try
        {
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            EnglishSentenceVo englishsentencevo = new EnglishSentenceVo();
            if (rs != null && rs.next())
            {

                englishsentencevo.setId(rs.getInt("id"));
                englishsentencevo.setSentence(rs.getString("sentence"));
            }
            return englishsentencevo;
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

    public int getEnglishSentenceRowCounts() throws Exception
    {
        int rowCounts = 0;
        String Sql = "select count(*) as rowcounts from TB_SENTENCE";
        try
        {
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            if (rs != null)
            {

                rowCounts = (rs.getInt("rowcounts"));
            }
            return rowCounts;
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


    public List<EnglishSentenceVo> getEnglishSentenceList() throws Exception
    {
        List<EnglishSentenceVo> englishsentenceList = new ArrayList<EnglishSentenceVo>();
        String Sql = "select * from TB_SENTENCE order by id desc";
        try
        {
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery(Sql);
            while (rs != null && rs.next())
            {
                EnglishSentenceVo englishsentencevo = new EnglishSentenceVo();
                englishsentencevo.setId(rs.getInt("id"));
                englishsentencevo.setSentence(rs.getString("sentence"));
                englishsentenceList.add(englishsentencevo);
            }
            return englishsentenceList;
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
