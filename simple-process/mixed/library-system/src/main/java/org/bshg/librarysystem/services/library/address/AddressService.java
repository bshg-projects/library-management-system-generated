package org.bshg.librarysystem.services.library.address;

import org.bshg.librarysystem.entity.core.library.Address;

import java.util.List;

public interface AddressService {
    Address findById(Long id);

    List<Address> findAllOptimized();

    List<Address> findAll();

    Address create(Address item);

    Address edit(Address item);

    void deleteById(Long id);

    void delete(Address item);

    void delete(List<Address> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByCountryId(Long id);

    List<Address> findByCountryId(Long id);
}