package org.bshg.librarysystem.librarybranch.sprocess.create;

import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.librarybranch.services.LibraryBranchService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateLibraryBranchProcessImpl extends AbstractCreateProcessImpl<LibraryBranch, LibraryBranchService> implements CreateLibraryBranchProcess {
    public CreateLibraryBranchProcessImpl(LibraryBranchService service, AddressService addressService) {
        super(service);
        this.addressService = addressService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LibraryBranch run(LibraryBranch item) {
// Your Insert Logic For 'LibraryBranch'
        item = service.create(item);
        return item;
    }

    private AddressService addressService;
    private CreateAddressProcess createAddressProcess;

    public void setCreateAddressProcess(CreateAddressProcess value) {
        this.createAddressProcess = value;
    }
}