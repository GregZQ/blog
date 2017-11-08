package com.zhangqii.pojo;

import java.util.Date;

public class TTitle {
    private Integer tid;

    private String tname;

    private Integer tcount;

    private Integer ttag;

    private String tab;

    private String tpic;

    private Date ttime;

    private Boolean ttype;
    private Boolean tstatus;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public Integer getTcount() {
        return tcount;
    }

    public void setTcount(Integer tcount) {
        this.tcount = tcount;
    }

    public Integer getTtag() {
        return ttag;
    }

    public void setTtag(Integer ttag) {
        this.ttag = ttag;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab == null ? null : tab.trim();
    }

    public String getTpic() {
        return tpic;
    }

    public void setTpic(String tpic) {
        this.tpic = tpic == null ? null : tpic.trim();
    }

    public Date getTtime() {
        return ttime;
    }

    public void setTtime(Date ttime) {
        this.ttime = ttime;
    }

    public Boolean getTtype() {
        return ttype;
    }

    public void setTtype(Boolean ttype) {
        this.ttype = ttype;
    }

    public Boolean getTstatus() {
        return tstatus;
    }

    public void setTstatus(Boolean tstatus) {
        this.tstatus = tstatus;
    }
}