package com.ultradns.ultra.rest.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class RenameObject {

    private String oldName;

    private String newName;

    public RenameObject() {
        super();
    }

    public RenameObject(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("oldName", oldName).add("newName", newName).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RenameObject that = (RenameObject) o;
        return Objects.equal(oldName, that.oldName) && Objects.equal(newName, that.newName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(oldName, newName);
    }
}
