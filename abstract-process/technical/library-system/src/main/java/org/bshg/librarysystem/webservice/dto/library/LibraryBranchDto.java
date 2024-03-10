package org.bshg.librarysystem.webservice.dto.library;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibraryBranchDto extends AuditBaseDto {
    public LibraryBranchDto() {
        super();
    }

    private String name;
    private AddressDto address;

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