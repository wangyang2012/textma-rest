package fr.textma.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebixTreeNode {

    private String id;

    private String value;

    private Boolean open;

    private List<WebixTreeNode> data;

    private Map<String, WebixTreeNode> hashedData;


    public WebixTreeNode() {
    }

    public WebixTreeNode(String id, String value) {
        this.id = id;
        this.value = value;
        this.open = false;
        this.data = new ArrayList<>();
        this.hashedData = new HashMap<>();
    }

    public WebixTreeNode(String id, String value, Boolean open) {
        this.id = id;
        this.value = value;
        this.open = open;
        this.data = new ArrayList<>();
        this.hashedData = new HashMap<>();
    }

    public WebixTreeNode(String id, String value, Boolean open, List<WebixTreeNode> data) {
        this.id = id;
        this.value = value;
        this.open = open;
        this.data = data;
        this.hashedData = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public List<WebixTreeNode> getData() {
        return data;
    }

    public void setData(List<WebixTreeNode> data) {
        this.data = data;
    }

    public Map<String, WebixTreeNode> getHashedData() {
        return hashedData;
    }

    public void setHashedData(Map<String, WebixTreeNode> hashedData) {
        this.hashedData = hashedData;
    }
}
