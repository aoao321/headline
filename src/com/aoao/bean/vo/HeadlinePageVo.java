package com.aoao.bean.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * 头条主页面
 *
 * @author aoao
 * @create 2025-02-15-17:59
 */
public class HeadlinePageVo implements Serializable {
    private static final long serialVersionUID = 5L;

    private Integer hid;
    private String title;
    private Integer type;
    private Integer pageViews;
    private Long pastHours;
    private Integer publisher;

    public HeadlinePageVo() {
    }

    public HeadlinePageVo(Integer hid, String title, Integer type, Integer pageViews, Long pastHours, Integer publisher) {
        this.hid = hid;
        this.title = title;
        this.type = type;
        this.pageViews = pageViews;
        this.pastHours = pastHours;
        this.publisher = publisher;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public Long getPastHours() {
        return pastHours;
    }

    public void setPastHours(Long pastHours) {
        this.pastHours = pastHours;
    }

    public Integer getPublisher() {
        return publisher;
    }

    public void setPublisher(Integer publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadlinePageVo that = (HeadlinePageVo) o;
        return Objects.equals(hid, that.hid) && Objects.equals(title, that.title) && Objects.equals(type, that.type) && Objects.equals(pageViews, that.pageViews) && Objects.equals(pastHours, that.pastHours) && Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hid, title, type, pageViews, pastHours, publisher);
    }

    @Override
    public String toString() {
        return "HeadlinePageVo{" +
                "id=" + hid +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", pageViews=" + pageViews +
                ", pastHours=" + pastHours +
                ", publisher=" + publisher +
                '}';
    }
}
