package org.bshg.librarysystem.librarybranch.sprocess;

import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.librarybranch.services.LibraryBranchService;
import org.bshg.librarysystem.librarybranch.sprocess.create.CreateLibraryBranchProcess;
import org.bshg.librarysystem.librarybranch.sprocess.create.CreateLibraryBranchProcessImpl;
import org.bshg.librarysystem.librarybranch.sprocess.delete.DeleteLibraryBranchProcess;
import org.bshg.librarysystem.librarybranch.sprocess.delete.DeleteLibraryBranchProcessImpl;
import org.bshg.librarysystem.librarybranch.sprocess.update.UpdateLibraryBranchProcess;
import org.bshg.librarysystem.librarybranch.sprocess.update.UpdateLibraryBranchProcessImpl;
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