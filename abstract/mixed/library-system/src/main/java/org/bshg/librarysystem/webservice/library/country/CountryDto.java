package org.bshg.librarysystem.webservice.library.country;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.webservice.library.address.AddressDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDto extends AuditBaseDto {
    public CountryDto() {
        super();
    }

    private String name;
    private List<AddressDto> addresses;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDto> value) {
        this.addresses = value;
    }
}