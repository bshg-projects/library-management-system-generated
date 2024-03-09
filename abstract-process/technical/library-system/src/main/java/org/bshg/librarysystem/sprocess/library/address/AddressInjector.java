package org.bshg.librarysystem.sprocess.library.address;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.UpdateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.impl.CreateAddressProcessImpl;
import org.bshg.librarysystem.sprocess.library.address.impl.UpdateAddressProcessImpl;
import org.bshg.librarysystem.sprocess.library.address.impl.DeleteAddressProcessImpl;
import org.bshg.librarysystem.services.facade.library.CountryService;
import org.bshg.librarysystem.sprocess.library.country.facade.CreateCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.facade.UpdateCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.facade.DeleteCountryProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.facade.DeleteLibraryBranchProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Address Processes (Create, Update, Delete).
*/
@Configuration
public class AddressInjector {
@Bean
public CreateAddressProcess createAddressProcess (AddressService service,CountryService countryService) {
var bean = new CreateAddressProcessImpl(service, countryService);
bean.setCreateCountryProcess(this.createCountryProcess);
return bean;
}
@Bean
public UpdateAddressProcess updateAddressProcess (AddressService service,CountryService countryService) {
var bean = new UpdateAddressProcessImpl(service,countryService);
bean.setUpdateCountryProcess(this.updateCountryProcess);
bean.setDeleteCountryProcess(this.deleteCountryProcess);
return bean;
}
@Bean
public DeleteAddressProcess deleteAddressProcess(AddressService service,CountryService countryService) {
var bean = new DeleteAddressProcessImpl(service,countryService);
bean.setDeleteCountryProcess(this.deleteCountryProcess);
bean.setDeleteEmployeeProcess(this.deleteEmployeeProcess);
bean.setDeletePublisherProcess(this.deletePublisherProcess);
bean.setDeleteLibraryBranchProcess(this.deleteLibraryBranchProcess);
return bean;
}
@Autowired @Lazy private CreateCountryProcess createCountryProcess;
@Autowired @Lazy private UpdateCountryProcess updateCountryProcess;
@Autowired @Lazy private DeleteCountryProcess deleteCountryProcess;
@Autowired @Lazy private DeleteEmployeeProcess deleteEmployeeProcess;
@Autowired @Lazy private DeletePublisherProcess deletePublisherProcess;
@Autowired @Lazy private DeleteLibraryBranchProcess deleteLibraryBranchProcess;
}