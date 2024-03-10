package org.bshg.librarysystem.librarybranch.sprocess.delete;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.librarybranch.services.LibraryBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteLibraryBranchProcessImpl implements DeleteLibraryBranchProcess {
    private void process(LibraryBranch item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(LibraryBranch item) {
        process(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        LibraryBranch item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            LibraryBranch item = service.findById(id);
            if (item != null) {
                process(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<LibraryBranch> items) {
        items.forEach(this::process);
        service.delete(items);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByAddress(Address address) {
        if (address != null && address.getId() != null) {
            service.deleteByAddressId(address.getId());
        }
    }

    @Autowired
    private LibraryBranchService service;
    @Autowired
    @Lazy
    private AddressService addressService;
    @Autowired
    @Lazy
    private DeleteAddressProcess deleteAddressProcess;
}