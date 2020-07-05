package com.jeason.mymallmbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class User implements Serializable {
    @ApiModelProperty(value = "user id")
    private Integer id;

    @ApiModelProperty(value = "user name")
    private String username;

    @ApiModelProperty(value = "user password")
    private String password;

    @ApiModelProperty(value = "user telephone")
    private String telephone;

    @ApiModelProperty(value = "user address")
    private String address;

    @ApiModelProperty(value = "user email")
    private String email;

    @ApiModelProperty(value = "user sex")
    private String sex;

    @ApiModelProperty(value = "credit")
    private Integer credit;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", telephone=").append(telephone);
        sb.append(", address=").append(address);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", credit=").append(credit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}