package com.example.hendawy.newsapp.model;

import java.util.ArrayList;
import java.util.List;

public class GrapFavIcon {

    private String domain;
    private List<Icons> icons  = new ArrayList<>();

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<Icons> getIcons() {
        return icons;
    }

    public void setIcons(List<Icons> icons) {
        this.icons = icons;
    }
}
