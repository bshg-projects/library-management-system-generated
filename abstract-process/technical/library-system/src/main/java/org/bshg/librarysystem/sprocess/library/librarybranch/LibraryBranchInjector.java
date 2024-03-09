package org.bshg.librarysystem.sprocess.library.librarybranch;
import org.bshg.librarysystem.services.facade.library.LibraryBranchService;
import org.bshg.librarysystem.sprocess.library.librarybranch.facade.CreateLibraryBranchProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.facade.UpdateLibraryBranchProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.facade.DeleteLibraryBranchProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.impl.CreateLibraryBranchProcessImpl;
import org.bshg.librarysystem.sprocess.library.librarybranch.impl.UpdateLibraryBranchProcessImpl;
import org.bshg.librarysystem.sprocess.library.librarybranch.impl.DeleteLibraryBranchProcessImpl;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.UpdateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject LibraryBranch Processes (Create, Update, Delete).
*/
@Configuration
public class LibraryBranchInjector {
@Bean
public CreateLibraryBranchProcess createLibraryBranchProcess (LibraryBranchService service,AddressService addressService) {
var bean = new CreateLibraryBranchProcessImpl(service, addressService);
bean.setCreateAddressProcess(this.createAddressProcess);
return bean;
}
@Bean
public UpdateLibraryBranchProcess updateLibraryBranchProcess (LibraryBranchService service,AddressService addressService) {
var bean = new UpdateLibraryBranchProcessImpl(service,addressService);
bean.setUpdateAddressProcess(this.updateAddressProcess);
bean.setDeleteAddressProcess(this.deleteAddressProcess);
return bean;
}
@Bean
public DeleteLibraryBranchProcess deleteLibraryBranchProcess(LibraryBranchService service,AddressService addressService) {
var bean = new DeleteLibraryBranchProcessImpl(service,addressService);
bean.setDeleteAddressProcess(this.deleteAddressProcess);
return bean;
}
@Autowired @Lazy private CreateAddressProcess createAddressProcess;
@Autowired @Lazy private UpdateAddressProcess updateAddressProcess;
@Autowired @Lazy private DeleteAddressProcess deleteAddressProcess;
}