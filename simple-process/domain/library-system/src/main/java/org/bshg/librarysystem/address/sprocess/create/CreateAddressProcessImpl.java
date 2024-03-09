package org.bshg.librarysystem.address.sprocess.create;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.country.sprocess.create.CreateCountryProcess;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateAddressProcessImpl implements CreateAddressProcess {
@Transactional(rollbackFor = Exception.class)
public Address run(Address item) {
// Your Creation Logic For 'Address'
item = service.create(item);
return item;
}
public List<Address> run(List<Address> items) {
items.forEach(this::run);
return items;
}
@Autowired private AddressService service;
@Autowired private CountryService countryService;
@Autowired @Lazy private CreateCountryProcess createCountryProcess;
}