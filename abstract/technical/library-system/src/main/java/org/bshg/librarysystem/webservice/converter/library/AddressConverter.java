package org.bshg.librarysystem.webservice.converter.library;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.bshg.librarysystem.webservice.dto.library.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter extends AbstractConverter<Address, AddressDto> {
    @Autowired
    private CountryConverter countryConverter;
    private boolean country = true;

    @Override
    protected void config() {
        config(Address.class, AddressDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.countryConverter.setAddresses(value);
    }

    @Override
    protected Address convertToItem(AddressDto dto) {
        var item = new Address();
        item.setId(dto.getId());
        item.setStreet(dto.getStreet());
        item.setCity(dto.getCity());
        item.setState(dto.getState());
        item.setZipCode(dto.getZipCode());
        item.setCountry(countryConverter.toItem(dto.getCountry()));
        return item;
    }

    @Override
    protected AddressDto convertToDto(Address item) {
        var dto = new AddressDto();
        dto.setId(item.getId());
        dto.setStreet(item.getStreet());
        dto.setCity(item.getCity());
        dto.setState(item.getState());
        dto.setZipCode(item.getZipCode());
        dto.setCountry(country ? countryConverter.toDto(item.getCountry()) : null);
        return dto;
    }

    public void setCountry(boolean value) {
        this.country = value;
    }

    public void setCountryConverter(CountryConverter value) {
        this.countryConverter = value;
    }

    public CountryConverter getCountryConverter() {
        return countryConverter;
    }
}