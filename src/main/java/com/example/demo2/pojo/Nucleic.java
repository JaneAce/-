package com.example.demo2.pojo;

import javax.xml.crypto.Data;
import java.util.Date;

public class Nucleic {
    private String username;
    private Date ndate;
    private String nresult;
    private String nimage;
    public Nucleic(){

    }
    public Nucleic(String username,Date ndate,String nresult,String nimage){
        this.username=username;
        this.ndate = ndate;
        this.nresult = nresult;
        this.nimage = nimage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getNdate() {
        return ndate;
    }

    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }

    public String getNresult() {
        return nresult;
    }

    public String getNimage() {
        return nimage;
    }

    public void setNimage(String nimage) {
        this.nimage = nimage;
    }

    public void setNresult(String nresult) {
        this.nresult = nresult;
    }

    @Override
    public String toString(){
        return "Nucleic{" +
                "username='" + username + '\'' +
                ", ndate='" + ndate + '\'' +
                ", nresult='" + nresult + '\'' +
                ", nimage='" + nimage + '\'' +
                '}';
    }
}
