package org.bshg.librarysystem.librarybranch.sprocess.create;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.librarybranch.services.LibraryBranchService;
import org.bshg.librarysystem.librarybranch.sprocess.create.CreateLibraryBranchProcess;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private LibraryBranchService service;
@Autowired private AddressService addressService;
@Autowired @Lazy private CreateAddressProcess createAddressProcess;
}