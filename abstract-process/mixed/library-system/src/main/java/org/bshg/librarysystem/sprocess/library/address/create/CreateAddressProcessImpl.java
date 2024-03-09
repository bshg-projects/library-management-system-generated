package org.bshg.librarysystem.sprocess.library.address.create;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.services.library.country.CountryService;
import org.bshg.librarysystem.sprocess.library.country.create.CreateCountryProcess;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateAddressProcessImpl extends AbstractCreateProcessImpl<Address, AddressService> implements CreateAddressProcess {
public CreateAddressProcessImpl(AddressService service, CountryService countryService) {
super(service);
this.countryService = countryService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Address run(Address item) {
// Your Insert Logic For 'Address'
item = service.create(item);
return item;
}
private CountryService countryService;
private CreateCountryProcess createCountryProcess;
public void setCreateCountryProcess(CreateCountryProcess value) {
this.createCountryProcess = value;
}
}