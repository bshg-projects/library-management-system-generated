package org.bshg.librarysystem.webservice.library.librarybranch;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.webservice.library.address.AddressDto;

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