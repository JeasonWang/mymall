package com.jeason.mymallmbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Orders implements Serializable {
    @ApiModelProperty(value = "id")
    private Integer orderid;

    @ApiModelProperty(value = "name")
    private String ordernm;

    private static final long serialVersionUID = 1L;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrdernm() {
        return ordernm;
    }

    public void setOrdernm(String ordernm) {
        this.ordernm = ordernm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderid=").append(orderid);
        sb.append(", ordernm=").append(ordernm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}