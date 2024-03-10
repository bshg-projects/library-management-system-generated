package org.bshg.librarysystem.utils.entity;

import java.io.Serializable;

/**
 * Supper Class For All Other Entities Classes
 */
public abstract class BaseEntity implements Serializable {

    protected BaseEntity() {
    }

    public abstract Long getId();

    public abstract void setId(Long id);

    @Override
    public boolean equals(Object object) {
        if (this.getId() != null && object instanceof BaseEntity businessObject) {
            return this.getId().equals(businessObject.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        Serializable pk = getId();
        if (pk == null) {
            return 0;
        }
        return pk.toString().hashCode();
    }

    @Override
    public String toString() {
        return this.getId() != null ? this.getId().toString() : null;
    }

}
