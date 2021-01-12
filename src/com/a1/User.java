package com.a1;

public class User {
    private Integer userid;
    private  String username;
    private String password;
    private String sex;
    private String email;

    public User() {
    }

    public User(String username, String password, String sex, String email) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }

    public User(Integer userid, String username, String password, String sex, String email) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
