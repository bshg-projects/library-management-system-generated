package org.bshg.librarysystem.sprocess.library.country;
import org.bshg.librarysystem.services.facade.library.CountryService;
import org.bshg.librarysystem.sprocess.library.country.facade.CreateCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.facade.UpdateCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.facade.DeleteCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.impl.CreateCountryProcessImpl;
import org.bshg.librarysystem.sprocess.library.country.impl.UpdateCountryProcessImpl;
import org.bshg.librarysystem.sprocess.library.country.impl.DeleteCountryProcessImpl;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.UpdateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Country Processes (Create, Update, Delete).
*/
@Configuration
public class CountryInjector {
@Bean
public CreateCountryProcess createCountryProcess (CountryService service,AddressService addressService) {
var bean = new CreateCountryProcessImpl(service, addressService);
bean.setCreateAddressProcess(this.createAddressProcess);
return bean;
}
@Bean
public UpdateCountryProcess updateCountryProcess (CountryService service,AddressService addressService) {
var bean = new UpdateCountryProcessImpl(service,addressService);
bean.setUpdateAddressProcess(this.updateAddressProcess);
bean.setDeleteAddressProcess(this.deleteAddressProcess);
return bean;
}
@Bean
public DeleteCountryProcess deleteCountryProcess(CountryService service,AddressService addressService) {
var bean = new DeleteCountryProcessImpl(service,addressService);
bean.setDeleteAddressProcess(this.deleteAddressProcess);
return bean;
}
@Autowired @Lazy private CreateAddressProcess createAddressProcess;
@Autowired @Lazy private UpdateAddressProcess updateAddressProcess;
@Autowired @Lazy private DeleteAddressProcess deleteAddressProcess;
}