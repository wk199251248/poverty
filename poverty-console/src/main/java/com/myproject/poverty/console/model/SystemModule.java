package com.myproject.poverty.console.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by miracle on 2017/3/8.
 */
@Entity
@Table(name = "system_module", schema = "poverty")
public class SystemModule implements Serializable {
    private int moduleId;
    private String moduleName;
    private String moduleUrl;
    private Short moduleOrder;
    private String moduleDesc;
    private Byte hasDeleted;

    @Id
    @Column(name = "module_id")
    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "module_name")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Basic
    @Column(name = "module_url")
    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    @Basic
    @Column(name = "module_order")
    public Short getModuleOrder() {
        return moduleOrder;
    }

    public void setModuleOrder(Short moduleOrder) {
        this.moduleOrder = moduleOrder;
    }

    @Basic
    @Column(name = "module_desc")
    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    @Basic
    @Column(name = "has_deleted")
    public Byte getHasDeleted() {
        return hasDeleted;
    }

    public void setHasDeleted(Byte hasDeleted) {
        this.hasDeleted = hasDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemModule that = (SystemModule) o;

        if (moduleId != that.moduleId) return false;
        if (moduleName != null ? !moduleName.equals(that.moduleName) : that.moduleName != null) return false;
        if (moduleUrl != null ? !moduleUrl.equals(that.moduleUrl) : that.moduleUrl != null) return false;
        if (moduleOrder != null ? !moduleOrder.equals(that.moduleOrder) : that.moduleOrder != null) return false;
        if (moduleDesc != null ? !moduleDesc.equals(that.moduleDesc) : that.moduleDesc != null) return false;
        if (hasDeleted != null ? !hasDeleted.equals(that.hasDeleted) : that.hasDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = moduleId;
        result = 31 * result + (moduleName != null ? moduleName.hashCode() : 0);
        result = 31 * result + (moduleUrl != null ? moduleUrl.hashCode() : 0);
        result = 31 * result + (moduleOrder != null ? moduleOrder.hashCode() : 0);
        result = 31 * result + (moduleDesc != null ? moduleDesc.hashCode() : 0);
        result = 31 * result + (hasDeleted != null ? hasDeleted.hashCode() : 0);
        return result;
    }
}
