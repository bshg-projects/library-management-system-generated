package org.bshg.librarysystem.sprocess.library.librarybranch.impl;

import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.services.facade.library.LibraryBranchService;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.facade.CreateLibraryBranchProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateLibraryBranchProcessImpl implements CreateLibraryBranchProcess {
    @Transactional(rollbackFor = Exception.class)
    public LibraryBranch run(LibraryBranch item) {
// Your Creation Logic For 'LibraryBranch'
        item = service.create(item);
        return item;
    }

    public List<LibraryBranch> run(List<LibraryBranch> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private LibraryBranchService service;
    @Autowired
    private AddressService addressService;
    @Autowired
    @Lazy
    private CreateAddressProcess createAddressProcess;
}