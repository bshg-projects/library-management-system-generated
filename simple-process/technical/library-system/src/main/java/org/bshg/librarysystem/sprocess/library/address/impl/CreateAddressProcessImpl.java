package org.bshg.librarysystem.sprocess.library.address.impl;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.services.facade.library.CountryService;
import org.bshg.librarysystem.sprocess.library.country.facade.CreateCountryProcess;
import org.bshg.librarysystem.entity.core.library.Country;
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