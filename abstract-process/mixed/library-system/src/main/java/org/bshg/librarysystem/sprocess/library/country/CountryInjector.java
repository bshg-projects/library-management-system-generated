package org.bshg.librarysystem.sprocess.library.country;
import org.bshg.librarysystem.services.library.country.CountryService;
import org.bshg.librarysystem.sprocess.library.country.create.CreateCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.update.UpdateCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.delete.DeleteCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.create.CreateCountryProcessImpl;
import org.bshg.librarysystem.sprocess.library.country.update.UpdateCountryProcessImpl;
import org.bshg.librarysystem.sprocess.library.country.delete.DeleteCountryProcessImpl;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.update.UpdateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcess;
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