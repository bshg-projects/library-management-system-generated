package org.bshg.librarysystem.country.sprocess.create;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.country.sprocess.create.CreateCountryProcess;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateCountryProcessImpl extends AbstractCreateProcessImpl<Country, CountryService> implements CreateCountryProcess {
public CreateCountryProcessImpl(CountryService service, AddressService addressService) {
super(service);
this.addressService = addressService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Country run(Country item) {
// Your Insert Logic For 'Country'
item = service.create(item);
createAssociatedList(item);
return item;
}
@Override
public void createAssociatedList(Country item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Country::getAddresses, Address::setCountry, createAddressProcess);
}
private AddressService addressService;
private CreateAddressProcess createAddressProcess;
public void setCreateAddressProcess(CreateAddressProcess value) {
this.createAddressProcess = value;
}
}