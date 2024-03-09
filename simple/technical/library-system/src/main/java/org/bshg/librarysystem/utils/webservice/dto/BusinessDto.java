package org.bshg.librarysystem.utils.webservice.dto;

import java.io.Serializable;

public class BusinessDto implements Serializable {

private Long id;

private String label;

public BusinessDto(Long id, String label) {
this.id = id;
this.label = label;
}

public BusinessDto() {
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

public void setId(Long id) {
this.id = id;
}

public void setLabel(String label) {
this.label = label;
}
}
