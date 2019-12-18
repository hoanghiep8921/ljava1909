/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpay.test.ottlicense;

/**
 *
 * @author quangtt
 */
public class LicenseEntity {

    private String bankCode;
    private String aesKey;
    private String macKey;
    private String keyId;
    private String urlRoot;
    private String pinning1;
    private String pinning2;
    private String pinning3;
    private String hostName;
    private String userName;
    private String password;
    private String bankName;
    private String bankToken;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getMacKey() {
        return macKey;
    }

    public void setMacKey(String macKey) {
        this.macKey = macKey;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getUrlRoot() {
        return urlRoot;
    }

    public void setUrlRoot(String urlRoot) {
        this.urlRoot = urlRoot;
    }

    public String getPinning1() {
        return pinning1;
    }

    public void setPinning1(String pinning1) {
        this.pinning1 = pinning1;
    }

    public String getPinning2() {
        return pinning2;
    }

    public void setPinning2(String pinning2) {
        this.pinning2 = pinning2;
    }

    public String getPinning3() {
        return pinning3;
    }

    public void setPinning3(String pinning3) {
        this.pinning3 = pinning3;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankToken() {
        return bankToken;
    }

    public void setBankToken(String bankToken) {
        this.bankToken = bankToken;
    }

}
