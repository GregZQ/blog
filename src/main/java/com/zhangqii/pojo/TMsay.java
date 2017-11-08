package com.zhangqii.pojo;

import java.util.Date;

public class TMsay {
    private Integer mid;

    private String mcon;
    private Date mtime;

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
}