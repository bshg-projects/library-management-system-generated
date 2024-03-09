package org.bshg.librarysystem.sprocess.library.librarybranch.create;
import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.services.library.librarybranch.LibraryBranchService;
import org.bshg.librarysystem.sprocess.library.librarybranch.create.CreateLibraryBranchProcess;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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