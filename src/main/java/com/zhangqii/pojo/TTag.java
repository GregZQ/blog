package com.zhangqii.pojo;

public class TTag {
    private Integer tid;

    private String tcon;

    private Integer tcount;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTcon() {
        return tcon;
    }

    public void setTcon(String tcon) {
        this.tcon = tcon == null ? null : tcon.trim();
    }

    public Integer getTcount() {
        return tcount;
    }

    public void setTcount(Integer tcount) {
        this.tcount = tcount;
    }
}