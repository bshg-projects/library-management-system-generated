package org.bshg.librarysystem.country.sprocess.create;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.country.sprocess.create.CreateCountryProcess;
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
public class CreateCountryProcessImpl implements CreateCountryProcess {
@Transactional(rollbackFor = Exception.class)
public Country run(Country item) {
// Your Creation Logic For 'Country'
item = service.create(item);
createAssociatedList(item);
return item;
}
public List<Country> run(List<Country> items) {
items.forEach(this::run);
return items;
}
public void createAssociatedList(Country item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Country::getAddresses, Address::setCountry, createAddressProcess::run);
}
@Autowired private CountryService service;
@Autowired private AddressService addressService;
@Autowired @Lazy private CreateAddressProcess createAddressProcess;
}