package org.bshg.librarysystem.webservice.library.librarybranch;

import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.bshg.librarysystem.webservice.library.address.AddressConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryBranchConverter extends AbstractConverter<LibraryBranch, LibraryBranchDto> {
    @Autowired
    private AddressConverter addressConverter;
    private boolean address = true;

    @Override
    protected void config() {
        config(LibraryBranch.class, LibraryBranchDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
    }

    @Override
    protected LibraryBranch convertToItem(LibraryBranchDto dto) {
        var item = new LibraryBranch();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setAddress(addressConverter.toItem(dto.getAddress()));
        return item;
    }

    @Override
    protected LibraryBranchDto convertToDto(LibraryBranch item) {
        var dto = new LibraryBranchDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setAddress(address ? addressConverter.toDto(item.getAddress()) : null);
        return dto;
    }

    public void setAddress(boolean value) {
        this.address = value;
    }

    public void setAddressConverter(AddressConverter value) {
        this.addressConverter = value;
    }

    public AddressConverter getAddressConverter() {
        return addressConverter;
    }
}