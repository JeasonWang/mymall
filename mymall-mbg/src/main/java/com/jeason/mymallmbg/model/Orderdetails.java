package com.jeason.mymallmbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Orderdetails implements Serializable {
    private Integer orderid;

    private Integer productionid;

    private Integer number;

    private static final long serialVersionUID = 1L;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getProductionid() {
        return productionid;
    }

    public void setProductionid(Integer productionid) {
        this.productionid = productionid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderid=").append(orderid);
        sb.append(", productionid=").append(productionid);
        sb.append(", number=").append(number);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}