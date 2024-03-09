package org.bshg.librarysystem.address.sprocess;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcessImpl;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcessImpl;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcessImpl;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.country.sprocess.create.CreateCountryProcess;
import org.bshg.librarysystem.country.sprocess.update.UpdateCountryProcess;
import org.bshg.librarysystem.country.sprocess.delete.DeleteCountryProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
import org.bshg.librarysystem.librarybranch.sprocess.delete.DeleteLibraryBranchProcess;
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