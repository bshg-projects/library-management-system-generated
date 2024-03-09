package org.bshg.librarysystem.utils.webservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class BaseDto implements Serializable {

protected Long id;
protected String label;
@JsonIgnore
protected int maxLevel = 2;

public BaseDto(Long id) {
this.id = id;
}

public BaseDto() {
}

@Override
public boolean equals(Object object) {
if (this.id != null && object instanceof BaseDto dto) {
return this.id.equals(dto.getId());
}
return false;
}


public int hashCode() {
Serializable pk = id;
if (pk == null) {
return 0;
}
return pk.toString().hashCode();
}

public String toString() {
return this.getId() != null ? this.getId().toString() : null;
}

public Long getId() {
return this.id;
}

public String getLabel() {
return this.label;
}

public int getMaxLevel() {
return this.maxLevel;
}

public void setId(Long id) {
this.id = id;
}

public void setLabel(String label) {
this.label = label;
}

@JsonIgnore
public void setMaxLevel(int maxLevel) {
this.maxLevel = maxLevel;
}
}
