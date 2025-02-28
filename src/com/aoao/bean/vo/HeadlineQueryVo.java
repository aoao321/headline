package com.aoao.bean.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * 分页信息
 *
 * @author aoao
 * @create 2025-02-15-17:54
 */
public class HeadlineQueryVo implements Serializable {
    private static final long serialVersionUID = 4L;

    private String keyWords;
    private Integer type;
    private Integer pageNum;
    private Integer pageSize;

    public HeadlineQueryVo() {}

    public HeadlineQueryVo(String keyWords, Integer type, Integer pageNum, Integer pageSize) {
        this.keyWords = keyWords;
        this.type = type;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadlineQueryVo that = (HeadlineQueryVo) o;
        return Objects.equals(keyWords, that.keyWords) && Objects.equals(type, that.type) && Objects.equals(pageNum, that.pageNum) && Objects.equals(pageSize, that.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyWords, type, pageNum, pageSize);
    }

    @Override
    public String toString() {
        return "HeadlineQueryVo{" +
                "keyWords='" + keyWords + '\'' +
                ", type=" + type +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
