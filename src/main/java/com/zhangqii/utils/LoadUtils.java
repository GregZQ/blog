package com.zhangqii.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Jone on 2017-11-12.
 */
@Component
public class LoadUtils {
    @Value("redis_password")
    private String passsword;
    @Value("redis_host")
    private String hostname;

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getHostname() {
        return hostname;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public String getPasssword() {
        return passsword;
    }
}
