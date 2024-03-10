package org.bshg.librarysystem.address;

import org.bshg.librarysystem.utils.repository.Repository;

import java.util.List;

public interface AddressDao extends Repository<Address, Long> {
    int deleteByCountryId(Long id);

    List<Address> findByCountryId(Long id);
}