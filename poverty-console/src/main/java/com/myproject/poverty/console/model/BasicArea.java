package com.myproject.poverty.console.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by miracle on 2017/3/8.
 */
@Entity
@Table(name = "basic_area", schema = "poverty")
public class BasicArea implements Serializable {
    private int areaId;
    private String areaName;
    private Integer areaType;

    @Id
    @Column(name = "area_id")
    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "area_name")
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Basic
    @Column(name = "area_type")
    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicArea basicArea = (BasicArea) o;

        if (areaId != basicArea.areaId) return false;
        if (areaName != null ? !areaName.equals(basicArea.areaName) : basicArea.areaName != null) return false;
        if (areaType != null ? !areaType.equals(basicArea.areaType) : basicArea.areaType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = areaId;
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        result = 31 * result + (areaType != null ? areaType.hashCode() : 0);
        return result;
    }
}
