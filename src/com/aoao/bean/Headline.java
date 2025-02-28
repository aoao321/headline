package com.aoao.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author aoao
 * @create 2025-02-15-16:25
 */
public class Headline implements Serializable {
    private static final long serialVersionUID = 3L;

    private int hid;
    private String title;
    private String article;
    private Integer type;
    private Integer publisher;
    private Integer pageViews;
    private Date createTime;
    private Date updateTime;
    private Integer isDelete;

    public Headline() {}

    public Headline(int hid, String title, String article, Integer type, Integer publisher, Integer pageViews, Date createTime, Date updateTime, Integer isDelete) {
        this.hid = hid;
        this.title = title;
        this.article = article;
        this.type = type;
        this.publisher = publisher;
        this.pageViews = pageViews;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPublisher() {
        return publisher;
    }

    public void setPublisher(Integer publisher) {
        this.publisher = publisher;
    }

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Headline headLine = (Headline) o;
        return hid == headLine.hid && Objects.equals(title, headLine.title) && Objects.equals(article, headLine.article) && Objects.equals(type, headLine.type) && Objects.equals(publisher, headLine.publisher) && Objects.equals(pageViews, headLine.pageViews) && Objects.equals(createTime, headLine.createTime) && Objects.equals(updateTime, headLine.updateTime) && Objects.equals(isDelete, headLine.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hid, title, article, type, publisher, pageViews, createTime, updateTime, isDelete);
    }

    @Override
    public String toString() {
        return "HeadLine{" +
                "id=" + hid +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", type=" + type +
                ", publisher=" + publisher +
                ", pageViews=" + pageViews +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
