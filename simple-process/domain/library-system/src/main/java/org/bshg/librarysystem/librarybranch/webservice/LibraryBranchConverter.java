package org.bshg.librarysystem.librarybranch.webservice;

import org.bshg.librarysystem.address.webservice.AddressConverter;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryBranchConverter {
    public void init(boolean initialisation) {
        this.address = initialisation;
    }

    @Autowired
    private AddressConverter addressConverter;
    private boolean address = true;

    protected void convertersConfig(boolean value) {
    }

    public final LibraryBranchDto toDto(LibraryBranch item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final LibraryBranch toItem(LibraryBranchDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<LibraryBranch> toItem(List<LibraryBranchDto> dtos) {
        if (dtos == null) return null;
        List<LibraryBranch> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<LibraryBranchDto> toDto(List<LibraryBranch> items) {
        if (items == null) return null;
        List<LibraryBranchDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    protected LibraryBranch convertToItem(LibraryBranchDto dto) {
        var item = new LibraryBranch();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setAddress(addressConverter.toItem(dto.getAddress()));
        return item;
    }

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