
package org.bshg.librarysystem.services.impl.library;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.repository.library.AddressDao;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.services.facade.library.CountryService;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.services.facade.library.LibraryBranchService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AddressServiceImpl extends ServiceImpl<Address, AddressDao> implements AddressService {
public AddressServiceImpl(AddressDao dao) {
super(dao);
}
@Override
public void deleteAssociatedObjects(Address item) {
if (item == null || item.getId() == null) return;
employeeService.deleteByAddressId(item.getId());
publisherService.deleteByAddressId(item.getId());
libraryBranchService.deleteByAddressId(item.getId());
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByCountryId(Long id){
if (id == null) return 0;
List<Address> found = findByCountryId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByCountryId(id);
}
@Override
public List<Address> findByCountryId(Long id){
return dao.findByCountryId(id);
}
@Lazy @Autowired private CountryService countryService;
@Lazy @Autowired private EmployeeService employeeService;
@Lazy @Autowired private PublisherService publisherService;
@Lazy @Autowired private LibraryBranchService libraryBranchService;
}