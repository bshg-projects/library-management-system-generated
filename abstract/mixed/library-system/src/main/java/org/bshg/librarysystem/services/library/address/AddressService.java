package org.bshg.librarysystem.services.library.address;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface AddressService extends IService<Address> {
    int deleteByCountryId(Long id);

    List<Address> findByCountryId(Long id);
}