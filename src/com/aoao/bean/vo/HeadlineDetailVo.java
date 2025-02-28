package com.aoao.bean.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * 头条内页面
 *
 * @author aoao
 * @create 2025-02-15-18:03
 */
public class HeadlineDetailVo implements Serializable {
    private static final long serialVersionUID = 6L;

    private Integer id;
    private String title;
    private String article;
    private Integer type;
    private String typeName;
    private Integer pageViews;
    private Long pastHours;
    private Integer publisher;
    private String author;

    public HeadlineDetailVo() {}

    public HeadlineDetailVo(Integer id, String title, String article, Integer type, String typeName, Integer pageViews, Long pastHours, Integer publisher, String author) {
        this.id = id;
        this.title = title;
        this.article = article;
        this.type = type;
        this.typeName = typeName;
        this.pageViews = pageViews;
        this.pastHours = pastHours;
        this.publisher = publisher;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadlineDetailVo that = (HeadlineDetailVo) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(article, that.article) && Objects.equals(type, that.type) && Objects.equals(typeName, that.typeName) && Objects.equals(pageViews, that.pageViews) && Objects.equals(pastHours, that.pastHours) && Objects.equals(publisher, that.publisher) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, article, type, typeName, pageViews, pastHours, publisher, author);
    }

    @Override
    public String toString() {
        return "HeadlineDetailVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", type=" + type +
                ", typeName='" + typeName + '\'' +
                ", pageViews=" + pageViews +
                ", pastHours=" + pastHours +
                ", publisher=" + publisher +
                ", author='" + author + '\'' +
                '}';
    }
}
