package org.bshg.librarysystem.sprocess.library.librarybranch;

import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.services.library.librarybranch.LibraryBranchService;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.update.UpdateAddressProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.create.CreateLibraryBranchProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.create.CreateLibraryBranchProcessImpl;
import org.bshg.librarysystem.sprocess.library.librarybranch.delete.DeleteLibraryBranchProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.delete.DeleteLibraryBranchProcessImpl;
import org.bshg.librarysystem.sprocess.library.librarybranch.update.UpdateLibraryBranchProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.update.UpdateLibraryBranchProcessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject LibraryBranch Processes (Create, Update, Delete).
 */
@Configuration
public class LibraryBranchInjector {
    @Bean
    public CreateLibraryBranchProcess createLibraryBranchProcess(LibraryBranchService service, AddressService addressService) {
        var bean = new CreateLibraryBranchProcessImpl(service, addressService);
        bean.setCreateAddressProcess(this.createAddressProcess);
        return bean;
    }

    @Bean
    public UpdateLibraryBranchProcess updateLibraryBranchProcess(LibraryBranchService service, AddressService addressService) {
        var bean = new UpdateLibraryBranchProcessImpl(service, addressService);
        bean.setUpdateAddressProcess(this.updateAddressProcess);
        bean.setDeleteAddressProcess(this.deleteAddressProcess);
        return bean;
    }

    @Bean
    public DeleteLibraryBranchProcess deleteLibraryBranchProcess(LibraryBranchService service, AddressService addressService) {
        var bean = new DeleteLibraryBranchProcessImpl(service, addressService);
        bean.setDeleteAddressProcess(this.deleteAddressProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateAddressProcess createAddressProcess;
    @Autowired
    @Lazy
    private UpdateAddressProcess updateAddressProcess;
    @Autowired
    @Lazy
    private DeleteAddressProcess deleteAddressProcess;
}