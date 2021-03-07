package main.java.com.gzmini.vo;

public class EnglishInfoVo {

    private int id;
    private String wordname;
    private String worddescribe;
    private String newtime;
    private int searchnum;

    public EnglishInfoVo() {

    }
    public int getId() {
        return this.id;
    }

    public void setId(int i_id) {
        this.id = i_id;
    }
    public String getWordname() {
        return this.wordname;
    }

    public void setWordname(String wordname) {
        this.wordname = wordname;
    }
    public String getWorddescribe() {
        return this.worddescribe;
    }
    public void setWorddescribe(String worddescribe) {
        this.worddescribe = worddescribe;
    }

    public void setNewtime(String newtime) {
        this.newtime = newtime;
    }
    public String getNewtime() {
        return this.newtime;
    }
    public void setSearchnum(int searchnum){
        this.searchnum = searchnum;
    }
    public int getSearchnum(){
        return this.searchnum;
    }
}

