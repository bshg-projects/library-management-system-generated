
package org.bshg.librarysystem.librarybranch.sprocess.delete;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.librarybranch.services.LibraryBranchService;
import org.bshg.librarysystem.librarybranch.sprocess.delete.DeleteLibraryBranchProcess;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteLibraryBranchProcessImpl extends AbstractDeleteProcessImpl<LibraryBranch, LibraryBranchService> implements DeleteLibraryBranchProcess {
public DeleteLibraryBranchProcessImpl(LibraryBranchService service, AddressService addressService) {
super(service);
this.addressService = addressService;
}
@Override
protected void process(LibraryBranch item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void deleteByAddress(Address address) {
if (address != null && address.getId() != null){
service.deleteByAddressId(address.getId());
}
}
private AddressService addressService;
private DeleteAddressProcess deleteAddressProcess;
public void setDeleteAddressProcess(DeleteAddressProcess value) {
this.deleteAddressProcess = value;
}
}