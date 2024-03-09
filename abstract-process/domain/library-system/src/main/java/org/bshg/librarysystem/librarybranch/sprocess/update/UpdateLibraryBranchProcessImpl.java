package org.bshg.librarysystem.librarybranch.sprocess.update;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.librarybranch.services.LibraryBranchService;
import org.bshg.librarysystem.librarybranch.sprocess.update.UpdateLibraryBranchProcess;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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