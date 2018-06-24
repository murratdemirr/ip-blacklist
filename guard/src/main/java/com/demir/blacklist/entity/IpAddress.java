package com.demir.blacklist.entity;

import java.time.LocalDateTime;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 11:47
 */
public class IpAddress {

    private String ip;
    private LocalDateTime bannedTime = LocalDateTime.now();

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getBannedTime() {
        return bannedTime;
    }

    public void setBannedTime(LocalDateTime bannedTime) {
        this.bannedTime = bannedTime;
    }
}
