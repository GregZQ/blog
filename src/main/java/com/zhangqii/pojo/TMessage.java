package com.zhangqii.pojo;

import java.util.Date;

public class TMessage {
    private Integer mid;

    private String mcon;

    private Date mtime;

    private String murl;

    private String mmail;

    private String mname;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMcon() {
        return mcon;
    }

    public void setMcon(String mcon) {
        this.mcon = mcon == null ? null : mcon.trim();
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl == null ? null : murl.trim();
    }

    public String getMmail() {
        return mmail;
    }

    public void setMmail(String mmail) {
        this.mmail = mmail == null ? null : mmail.trim();
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }
}