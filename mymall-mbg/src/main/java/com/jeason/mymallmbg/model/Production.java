package com.jeason.mymallmbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Production implements Serializable {
    private Integer productionid;

    private String productionnm;

    private Integer number;

    private static final long serialVersionUID = 1L;

    public Integer getProductionid() {
        return productionid;
    }

    public void setProductionid(Integer productionid) {
        this.productionid = productionid;
    }

    public String getProductionnm() {
        return productionnm;
    }

    public void setProductionnm(String productionnm) {
        this.productionnm = productionnm;
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
        sb.append(", productionid=").append(productionid);
        sb.append(", productionnm=").append(productionnm);
        sb.append(", number=").append(number);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}