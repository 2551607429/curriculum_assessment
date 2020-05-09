package com.zx.sys.model;

import java.io.Serializable;

public class RegistrationKey implements Serializable {
    private Integer id;

    private String keyName;

    private String registerKey;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    public String getRegisterKey() {
        return registerKey;
    }

    public void setRegisterKey(String registerKey) {
        this.registerKey = registerKey == null ? null : registerKey.trim();
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
        RegistrationKey other = (RegistrationKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getKeyName() == null ? other.getKeyName() == null : this.getKeyName().equals(other.getKeyName()))
            && (this.getRegisterKey() == null ? other.getRegisterKey() == null : this.getRegisterKey().equals(other.getRegisterKey()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getKeyName() == null) ? 0 : getKeyName().hashCode());
        result = prime * result + ((getRegisterKey() == null) ? 0 : getRegisterKey().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", keyName=").append(keyName);
        sb.append(", registerKey=").append(registerKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}