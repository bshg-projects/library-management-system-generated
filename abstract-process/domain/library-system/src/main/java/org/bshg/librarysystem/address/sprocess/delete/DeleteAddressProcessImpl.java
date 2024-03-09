
package org.bshg.librarysystem.address.sprocess.delete;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.country.sprocess.delete.DeleteCountryProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
import org.bshg.librarysystem.librarybranch.sprocess.delete.DeleteLibraryBranchProcess;
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