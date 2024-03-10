package org.bshg.librarysystem.sprocess.library.address;

import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.services.library.country.CountryService;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcessImpl;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcessImpl;
import org.bshg.librarysystem.sprocess.library.address.update.UpdateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.update.UpdateAddressProcessImpl;
import org.bshg.librarysystem.sprocess.library.country.create.CreateCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.delete.DeleteCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.update.UpdateCountryProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.delete.DeleteLibraryBranchProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Address Processes (Create, Update, Delete).
 */
@Configuration
public class AddressInjector {
    @Bean
    public CreateAddressProcess createAddressProcess(AddressService service, CountryService countryService) {
        var bean = new CreateAddressProcessImpl(service, countryService);
        bean.setCreateCountryProcess(this.createCountryProcess);
        return bean;
    }

    @Bean
    public UpdateAddressProcess updateAddressProcess(AddressService service, CountryService countryService) {
        var bean = new UpdateAddressProcessImpl(service, countryService);
        bean.setUpdateCountryProcess(this.updateCountryProcess);
        bean.setDeleteCountryProcess(this.deleteCountryProcess);
        return bean;
    }

    @Bean
    public DeleteAddressProcess deleteAddressProcess(AddressService service, CountryService countryService) {
        var bean = new DeleteAddressProcessImpl(service, countryService);
        bean.setDeleteCountryProcess(this.deleteCountryProcess);
        bean.setDeleteEmployeeProcess(this.deleteEmployeeProcess);
        bean.setDeletePublisherProcess(this.deletePublisherProcess);
        bean.setDeleteLibraryBranchProcess(this.deleteLibraryBranchProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateCountryProcess createCountryProcess;
    @Autowired
    @Lazy
    private UpdateCountryProcess updateCountryProcess;
    @Autowired
    @Lazy
    private DeleteCountryProcess deleteCountryProcess;
    @Autowired
    @Lazy
    private DeleteEmployeeProcess deleteEmployeeProcess;
    @Autowired
    @Lazy
    private DeletePublisherProcess deletePublisherProcess;
    @Autowired
    @Lazy
    private DeleteLibraryBranchProcess deleteLibraryBranchProcess;
}