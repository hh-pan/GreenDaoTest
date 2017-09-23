package com.example.greendaotest;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/9/23.
 */

@Entity
public class User {
    private String username;
    private String age;
    @Generated(hash = 1738996559)
    public User(String username, String age) {
        this.username = username;
        this.age = age;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}
