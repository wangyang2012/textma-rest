package fr.textma.model;

import java.util.List;

public class WebixTreeNode {

    private Integer id;

    private String value;

    private Boolean open;

    private List<WebixTreeNode> data;


    public WebixTreeNode() {
    }

    public WebixTreeNode(Integer id, String value, Boolean open) {
        this.id = id;
        this.value = value;
        this.open = open;
    }

    public WebixTreeNode(Integer id, String value, Boolean open, List<WebixTreeNode> data) {
        this.id = id;
        this.value = value;
        this.open = open;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
