package com.no.company.DataGenerator;

public class LogLineData {
    private String id;
    private String State;
    private String type;
    private String host;
    private String timestamp;
    private boolean usedAlready;

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

    public void setUsedAlready(boolean usedAlready) {
        this.usedAlready = usedAlready;
    }

    public boolean isUsedAlready() {
        return usedAlready;
    }
}
