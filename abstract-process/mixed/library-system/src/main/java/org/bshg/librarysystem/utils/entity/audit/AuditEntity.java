package org.bshg.librarysystem.utils.entity.audit;

import org.bshg.librarysystem.utils.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import java.time.LocalDate;

/**
* Supper Class For All Other Entities Classes
*/
@MappedSuperclass
@EntityListeners(EntityListener.class)
public abstract class AuditEntity extends BaseEntity {
@JsonProperty(access = Access.READ_ONLY)
private LocalDateTime createdOn;

@JsonProperty(access = Access.READ_ONLY)
private LocalDateTime updatedOn;

@JsonProperty(access = Access.READ_ONLY)
private String createdBy;

@JsonProperty(access = Access.READ_ONLY)
private String updatedBy;

protected AuditEntity() {
}

public LocalDateTime getCreatedOn() {
return this.createdOn;
}

public LocalDateTime getUpdatedOn() {
return this.updatedOn;
}

public String getCreatedBy() {
return this.createdBy;
}

public String getUpdatedBy() {
return this.updatedBy;
}

@JsonProperty(access = Access.READ_ONLY)
public void setCreatedOn(LocalDateTime createdOn) {
this.createdOn = createdOn;
}

@JsonProperty(access = Access.READ_ONLY)
public void setUpdatedOn(LocalDateTime updatedOn) {
this.updatedOn = updatedOn;
}

@JsonProperty(access = Access.READ_ONLY)
public void setCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

@JsonProperty(access = Access.READ_ONLY)
public void setUpdatedBy(String updatedBy) {
this.updatedBy = updatedBy;
}
}
