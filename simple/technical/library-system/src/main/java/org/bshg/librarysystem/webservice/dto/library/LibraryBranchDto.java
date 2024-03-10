package org.bshg.librarysystem.webservice.dto.library;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibraryBranchDto {
    private Long id;
    private String name;
    private AddressDto address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto value) {
        this.address = value;
    }
}