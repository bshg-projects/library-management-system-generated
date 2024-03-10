package org.bshg.librarysystem.country.webservice;

import org.bshg.librarysystem.address.webservice.AddressConverter;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryConverter extends AbstractConverter<Country, CountryDto> {
    @Autowired
    private AddressConverter addressConverter;
    private boolean addresses = true;

    @Override
    protected void convertersConfig(boolean value) {
        this.addressConverter.setCountry(value);
    }

    @Override
    protected Country convertToItem(CountryDto dto) {
        var item = new Country();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setAddresses(addressConverter.toItem(dto.getAddresses()));
        return item;
    }

    @Override
    protected CountryDto convertToDto(Country item) {
        var dto = new CountryDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setAddresses(addresses ? addressConverter.toDto(item.getAddresses()) : null);
        return dto;
    }

    public void setAddresses(boolean value) {
        this.addresses = value;
    }

    public void setAddressConverter(AddressConverter value) {
        this.addressConverter = value;
    }

    public AddressConverter getAddressConverter() {
        return addressConverter;
    }
}