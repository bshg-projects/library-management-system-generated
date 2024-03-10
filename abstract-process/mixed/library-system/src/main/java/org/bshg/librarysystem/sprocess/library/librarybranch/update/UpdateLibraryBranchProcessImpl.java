package org.bshg.librarysystem.sprocess.library.librarybranch.update;

import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.services.library.librarybranch.LibraryBranchService;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.update.UpdateAddressProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateLibraryBranchProcessImpl extends AbstractUpdateProcessImpl<LibraryBranch, LibraryBranchService> implements UpdateLibraryBranchProcess {
    public UpdateLibraryBranchProcessImpl(LibraryBranchService service, AddressService addressService) {
        super(service);
        this.addressService = addressService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LibraryBranch run(LibraryBranch item) {
// Your Update Logic For 'LibraryBranch'
        item = service.edit(item);
        return item;
    }

    private AddressService addressService;
    private UpdateAddressProcess updateAddressProcess;
    private DeleteAddressProcess deleteAddressProcess;

    public void setUpdateAddressProcess(UpdateAddressProcess value) {
        this.updateAddressProcess = value;
    }

    public void setDeleteAddressProcess(DeleteAddressProcess value) {
        this.deleteAddressProcess = value;
    }
}