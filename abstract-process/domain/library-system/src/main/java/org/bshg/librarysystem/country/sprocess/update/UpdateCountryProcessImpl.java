package org.bshg.librarysystem.country.sprocess.update;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.country.sprocess.update.UpdateCountryProcess;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateCountryProcessImpl extends AbstractUpdateProcessImpl<Country, CountryService> implements UpdateCountryProcess {
public UpdateCountryProcessImpl(CountryService service, AddressService addressService) {
super(service);
this.addressService = addressService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Country run(Country item) {
// Your Update Logic For 'Country'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
@Override
public void updateAssociatedList(Country item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
addressService::findByCountryId,
Country::getAddresses,
Address::setCountry,
updateAddressProcess,
deleteAddressProcess
);
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