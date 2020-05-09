package com.zx.sys.model;

import java.io.Serializable;

public class StudyKey implements Serializable {
    private Integer stuId;

    private Integer knowsId;

    private static final long serialVersionUID = 1L;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getKnowsId() {
        return knowsId;
    }

    public void setKnowsId(Integer knowsId) {
        this.knowsId = knowsId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        StudyKey other = (StudyKey) that;
        return (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getKnowsId() == null ? other.getKnowsId() == null : this.getKnowsId().equals(other.getKnowsId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getKnowsId() == null) ? 0 : getKnowsId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuId=").append(stuId);
        sb.append(", knowsId=").append(knowsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}