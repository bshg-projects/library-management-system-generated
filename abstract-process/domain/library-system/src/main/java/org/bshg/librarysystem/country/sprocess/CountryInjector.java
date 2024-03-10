package org.bshg.librarysystem.country.sprocess;

import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.country.sprocess.create.CreateCountryProcess;
import org.bshg.librarysystem.country.sprocess.create.CreateCountryProcessImpl;
import org.bshg.librarysystem.country.sprocess.delete.DeleteCountryProcess;
import org.bshg.librarysystem.country.sprocess.delete.DeleteCountryProcessImpl;
import org.bshg.librarysystem.country.sprocess.update.UpdateCountryProcess;
import org.bshg.librarysystem.country.sprocess.update.UpdateCountryProcessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Country Processes (Create, Update, Delete).
 */
@Configuration
public class CountryInjector {
    @Bean
    public CreateCountryProcess createCountryProcess(CountryService service, AddressService addressService) {
        var bean = new CreateCountryProcessImpl(service, addressService);
        bean.setCreateAddressProcess(this.createAddressProcess);
        return bean;
    }

    @Bean
    public UpdateCountryProcess updateCountryProcess(CountryService service, AddressService addressService) {
        var bean = new UpdateCountryProcessImpl(service, addressService);
        bean.setUpdateAddressProcess(this.updateAddressProcess);
        bean.setDeleteAddressProcess(this.deleteAddressProcess);
        return bean;
    }

    @Bean
    public DeleteCountryProcess deleteCountryProcess(CountryService service, AddressService addressService) {
        var bean = new DeleteCountryProcessImpl(service, addressService);
        bean.setDeleteAddressProcess(this.deleteAddressProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateAddressProcess createAddressProcess;
    @Autowired
    @Lazy
    private UpdateAddressProcess updateAddressProcess;
    @Autowired
    @Lazy
    private DeleteAddressProcess deleteAddressProcess;
}