package fr.textma.model;

import java.util.List;

public class WebixSort {
    List<WebixSortColumn> sort;

    public WebixSort() {
    }

    public WebixSort(List<WebixSortColumn> sort) {
        this.sort = sort;
    }

    public List<WebixSortColumn> getSort() {
        return sort;
    }

    public void setSort(List<WebixSortColumn> sort) {
        this.sort = sort;
    }
}
