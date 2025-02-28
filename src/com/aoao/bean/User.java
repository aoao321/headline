package com.aoao.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author aoao
 * @create 2025-02-15-16:11
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer uid;

    private String username;

    @JsonProperty("userPwd")
    private String password;

    private String nickName;

    public User() {}

    public User(Integer uid, String username, String password, String nickName) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.nickName = nickName;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(nickName, user.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, password, nickName);
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + username + '\'' +
                ", password=" + password +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
