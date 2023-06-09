package com.matthewgitata.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * created by @matthewgitata on 22/03/2023.
 */
public class Job implements Serializable {
    private String title;
    private String company;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4985150429002262656L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}