package com.th.guangxismz.Bean;

public class CommonSendBo {
    private String addr;
    private String apiKey;
    private String clientSerial;
    private String apiSecret;
    private String apiVersion;
    private String data;
    private String signature;
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return apiSecret + "api_key" + apiKey + "api_version" + apiVersion + "body" + data + "client_serial" + clientSerial + "timestamp" + timestamp + apiSecret;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getClientSerial() {
        return clientSerial;
    }

    public void setClientSerial(String clientSerial) {
        this.clientSerial = clientSerial;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
