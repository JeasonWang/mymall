package com.jeason.mymallmbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Role implements Serializable {
    @ApiModelProperty(value = "role id")
    private Integer id;

    @ApiModelProperty(value = "role name")
    private String rolename;

    @ApiModelProperty(value = "role zhongwen")
    private String rolezh;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolezh() {
        return rolezh;
    }

    public void setRolezh(String rolezh) {
        this.rolezh = rolezh;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rolename=").append(rolename);
        sb.append(", rolezh=").append(rolezh);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}