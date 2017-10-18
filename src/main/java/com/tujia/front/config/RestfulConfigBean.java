/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tujia.front.config;

/**
 *
 * @author huangwei
 */
public class RestfulConfigBean {
    public RestfulConfigBean(String host) {
        this.host = host;
    }
    
    public RestfulConfigBean(String host, boolean isHTTPs) {
        this.host = host;
        this.isHTTPs = isHTTPs;
    }
    
    public RestfulConfigBean() {
        this(null);
    }
    
    public void setHost(String host) {
        this.host = host;
    }
    
    public void setIsHTTPs(boolean is) {
        isHTTPs = is;
    }
    
    public boolean getIsHTTPs() {
        return isHTTPs;
    }
    
    public String getHost() {
        return host;
    }
    
    public String getApiUrl(String path) {
        String realPath = "";
        if (path != null) {
            realPath = path;
            if (!realPath.startsWith("/")) {
                realPath = "/" + realPath;
            }
        }
        return (isHTTPs ? "https://" : "http://") + host + realPath;
    }
    
    private String host;
    private boolean isHTTPs = true;
}
