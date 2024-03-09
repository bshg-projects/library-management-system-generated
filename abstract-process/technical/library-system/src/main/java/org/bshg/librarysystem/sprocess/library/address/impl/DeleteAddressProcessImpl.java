
package org.bshg.librarysystem.sprocess.library.address.impl;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.services.facade.library.CountryService;
import org.bshg.librarysystem.sprocess.library.country.facade.DeleteCountryProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.facade.DeleteLibraryBranchProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteAddressProcessImpl extends AbstractDeleteProcessImpl<Address, AddressService> implements DeleteAddressProcess {
public DeleteAddressProcessImpl(AddressService service, CountryService countryService) {
super(service);
this.countryService = countryService;
}
@Override
protected void process(Address item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
public void deleteByCountry(Country country) {
if (country != null && country.getId() != null){
List<Address> found = this.service.findByCountryId(country.getId());
if (found == null) return;
found.forEach(this::deleteAssociated);
service.deleteByCountryId(country.getId());
}
}
@Override
public void deleteAssociatedObjects(Address item) {
deleteEmployeeProcess.deleteByAddress(item);
deletePublisherProcess.deleteByAddress(item);
deleteLibraryBranchProcess.deleteByAddress(item);
}
private CountryService countryService;
private DeleteCountryProcess deleteCountryProcess;
public void setDeleteCountryProcess(DeleteCountryProcess value) {
this.deleteCountryProcess = value;
}
private DeleteEmployeeProcess deleteEmployeeProcess;
public void setDeleteEmployeeProcess(DeleteEmployeeProcess value) {
this.deleteEmployeeProcess = value;
}
private DeletePublisherProcess deletePublisherProcess;
public void setDeletePublisherProcess(DeletePublisherProcess value) {
this.deletePublisherProcess = value;
}
private DeleteLibraryBranchProcess deleteLibraryBranchProcess;
public void setDeleteLibraryBranchProcess(DeleteLibraryBranchProcess value) {
this.deleteLibraryBranchProcess = value;
}
}