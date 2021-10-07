package com.no.company.logic;

public class DataFromFile {
    private String id;
    private String State;
    private String type;
    private String host;
    private String timestamp;
    private Long howLongEventTook;
    private boolean isToLong;

    public void setId(String id) {
        this.id = id;
    }

    public void setState(String state) {
        State = state;
    }

    public String getId() {
        return id;
    }

    public String getState() {
        return State;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setToLong(boolean toLong) {
        this.isToLong = toLong;
    }

    public boolean isToLong() {
        return isToLong;
    }

    public Long getHowLongEventTook() {
        return howLongEventTook;
    }

    public void setHowLongEventTook(Long howLongEventTook) {
        this.howLongEventTook = howLongEventTook;
    }
}
