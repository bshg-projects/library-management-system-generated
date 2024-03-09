
package org.bshg.librarysystem.sprocess.library.address.delete;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcess;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.services.library.country.CountryService;
import org.bshg.librarysystem.sprocess.library.country.delete.DeleteCountryProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.delete.DeleteLibraryBranchProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteAddressProcessImpl implements DeleteAddressProcess {
private void process(Address item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Address item) {
process(item);
deleteAssociated(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Address item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Address item = service.findById(id);
if (item != null) {
process(item);
deleteAssociated(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Address> items) {
items.forEach(this::process);
items.forEach(this::deleteAssociated);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByCountry(Country country) {
if (country != null && country.getId() != null){
List<Address> found = this.service.findByCountryId(country.getId());
if (found == null) return;
found.forEach(this::deleteAssociated);
service.deleteByCountryId(country.getId());
}
}
@Transactional(rollbackFor = Exception.class)
protected void deleteAssociated(Address item) {
if (item == null || item.getId() == null) return;
deleteAssociatedObjects(item);
}
private void deleteAssociatedObjects(Address item) {
deleteEmployeeProcess.deleteByAddress(item);
deletePublisherProcess.deleteByAddress(item);
deleteLibraryBranchProcess.deleteByAddress(item);
}
@Autowired private AddressService service;
@Autowired @Lazy private CountryService countryService;
@Autowired @Lazy private DeleteCountryProcess deleteCountryProcess;
@Autowired @Lazy private DeleteEmployeeProcess deleteEmployeeProcess;
@Autowired @Lazy private DeletePublisherProcess deletePublisherProcess;
@Autowired @Lazy private DeleteLibraryBranchProcess deleteLibraryBranchProcess;
}