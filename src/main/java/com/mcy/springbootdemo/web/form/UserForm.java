package com.mcy.springbootdemo.web.form;

import com.mcy.springbootdemo.custom.BaseForm;

public class UserForm extends BaseForm<Integer> {
    private String username;    //姓名，username
    private String loginName;   //登录名
    private Integer age;    //年龄

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
