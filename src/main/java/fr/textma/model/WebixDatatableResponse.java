package fr.textma.model;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by ywang on 12/10/17.
 */
public class WebixDatatableResponse<T> {
    private List<T> data;
    private Integer pos;
    private Long total_count;

    public WebixDatatableResponse(Page<T> page, Integer start) {
        this.pos = start;
        this.total_count = page.getTotalElements();
        this.data = page.getContent();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Long getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Long total_count) {
        this.total_count = total_count;
    }
}
