package org.bshg.librarysystem.country.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.address.webservice.AddressDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDto {
    private Long id;
    private String name;
    private List<AddressDto> addresses;

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

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDto> value) {
        this.addresses = value;
    }
}