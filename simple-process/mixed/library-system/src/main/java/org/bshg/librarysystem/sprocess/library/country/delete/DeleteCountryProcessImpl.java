
package org.bshg.librarysystem.sprocess.library.country.delete;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.services.library.country.CountryService;
import org.bshg.librarysystem.sprocess.library.country.delete.DeleteCountryProcess;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteCountryProcessImpl implements DeleteCountryProcess {
private void process(Country item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Country item) {
process(item);
deleteAssociated(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Country item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Country item = service.findById(id);
if (item != null) {
process(item);
deleteAssociated(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Country> items) {
items.forEach(this::process);
items.forEach(this::deleteAssociated);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
protected void deleteAssociated(Country item) {
if (item == null || item.getId() == null) return;
deleteAssociatedList(item);
}
private void deleteAssociatedList(Country item) {
deleteAddressProcess.deleteByCountry(item);
}
@Autowired private CountryService service;
@Autowired @Lazy private AddressService addressService;
@Autowired @Lazy private DeleteAddressProcess deleteAddressProcess;
}