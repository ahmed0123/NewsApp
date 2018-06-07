package com.example.hendawy.newsapp.model;

public class Icons {

    private String src;
    private String type;

    public Icons() {
    }

    public Icons(String src, String type) {
        this.src = src;
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
